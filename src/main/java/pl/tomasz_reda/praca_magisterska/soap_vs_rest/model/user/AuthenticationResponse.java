package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user;

import lombok.*;

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
