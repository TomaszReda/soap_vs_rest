package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.config.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service.UserServiceRest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    private UserServiceRest userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserAuthenticationProvider(UserServiceRest userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {

        //Get User to take roles
        if (authentication.getPrincipal() == null) {
            throw new IllegalArgumentException("Uzupełnij wszystkie pola!");
        }

        User user = userService.getUserByEmail(authentication.getPrincipal().toString());
        if (user == null) {
            log.debug("Authentication Failed: User with this email does not exist.");
            throw new IllegalArgumentException("Niepoprawny email lub hasło");
        }

        String password = authentication.getCredentials().toString();
        if (password.equals(user.getPassword())) {
            List<GrantedAuthority> userRoleEnums = new ArrayList<>();


                userRoleEnums.add(new SimpleGrantedAuthority("ROLE_" + user.getUserRoles().getUserRole().toString()));

            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
                    user.getEmail(), password, userRoleEnums);
        } else {
            log.debug("Authentication Failed: Bad password");
            throw new IllegalArgumentException("Niepoprawny email lub hasło");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}