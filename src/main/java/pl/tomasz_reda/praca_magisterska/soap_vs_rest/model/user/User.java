package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;


import javax.jdo.annotations.Unique;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Model user for SOAP and REST . .
 * @author Tomasz Reda
 * */
@Slf4j
@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`user`")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String phoneNumber;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRoles userRoles;

}
