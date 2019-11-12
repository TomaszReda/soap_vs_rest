package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
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
@Table(name = "`user`")
public class User {


    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String firstname;

    private String lastname;

    private String email;

    private int phoneNumber;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private UserMenager userMenager;

    @OneToOne(cascade = CascadeType.ALL)
    private UserCasual userCasual;

    @OneToOne
    private UserRoles userRoles ;


    public User(String firstname, String lastname, String email, int phoneNumber, String password, UserMenager userMenager, UserCasual userCasual, UserRoles userRoles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userMenager = userMenager;
        this.userCasual = userCasual;
        this.userRoles = userRoles;
    }
}
