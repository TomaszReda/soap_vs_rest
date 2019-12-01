package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto;

import lombok.Data;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserRoles;

import java.util.UUID;

@Data
public class UserDto {

    private Long Id;

    private String firstname;

    private String lastname;

    private String email;

    private int phoneNumber;

    private String password;

    private UserRoles userRoles;

}
