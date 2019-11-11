package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.message.MessageToCasualUser;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.task.Task;

import javax.persistence.*;
import java.util.ArrayList;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ActivationUserToken activationUserToken;

    @Enumerated(EnumType.STRING)
    private UserState userState;

    @OneToOne(cascade = CascadeType.ALL)
    private UserMenager userMenager;

    @OneToOne(cascade = CascadeType.ALL)
    private UserCasual userCasual;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<UserRoles> userRoles = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ResetPasswordToken resetPasswordToken;

    @OneToMany(mappedBy = "user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Task> taskList=new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<MessageToCasualUser>   messageToCasualUsers=new ArrayList<>();

    public User() {
    }

    public User(String firstname, String lastname, String email, int phoneNumber, String password,UserState userState) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userState=userState;
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                ", activationUserToken=" + activationUserToken +
                ", userState=" + userState +
                ", userMenager=" + userMenager +
                ", userCasual=" + userCasual +
                ", userRoles=" + userRoles +
                ", resetPasswordToken=" + resetPasswordToken +
                '}';
    }
}
