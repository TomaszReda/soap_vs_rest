package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class AuthService {

    @Autowired
    private  AuthenticationManager authenticationManager;




    public ResponseEntity<AuthenticationResponse> login(@RequestBody Credentials credentials, HttpServletRequest request) {
        final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword());
        final Authentication authentication = this.authenticationManager.authenticate(token);
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        final HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext()
        );
        log.info("[Logged]=" + authentication.getName());
        return ResponseEntity.ok(new AuthenticationResponse(authentication.getName(), httpSession.getId()));

    }
}
