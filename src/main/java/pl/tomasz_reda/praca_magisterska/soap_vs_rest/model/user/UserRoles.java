package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Model user role for SOAP and REST . .
 * @author Tomasz Reda
 * */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ROLES")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum userRole;

    @OneToMany(mappedBy = "userRoles")
    @JsonIgnore
    private List<User> users = new ArrayList<>();


}