package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AuthenticationResponse {
    private String username;
    private String token;

    public AuthenticationResponse(String username, String token) {
        this.username = username;
        this.token = token;
    }
}
