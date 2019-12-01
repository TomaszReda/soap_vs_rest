package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

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

    private int phoneNumber;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRoles userRoles;

}
