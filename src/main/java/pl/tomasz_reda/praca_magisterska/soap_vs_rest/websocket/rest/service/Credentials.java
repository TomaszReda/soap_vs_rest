package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
    private String email;
    private String password;
}
