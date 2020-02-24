package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service.AuthService;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service.AuthenticationResponse;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service.Credentials;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/rest")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Credentials credentials, HttpServletRequest request) {
        return authService.login(credentials, request);
    }

    @GetMapping(value = "/logout")
    public ResponseEntity logout(HttpSession session) {

        session.invalidate();
        return ResponseEntity.ok().build();
    }

}
