package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/rest")
public class SecureController {


    @PreAuthorize("hasAuthority('ROLE_CASUAL_USER')")
    @GetMapping("/secure")
    public ResponseEntity<String> secure() {

        return ResponseEntity.ok("secure");
    }


    @GetMapping("/logged/user")
    public ResponseEntity<String> logged() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return ResponseEntity.ok(username);
    }
}
