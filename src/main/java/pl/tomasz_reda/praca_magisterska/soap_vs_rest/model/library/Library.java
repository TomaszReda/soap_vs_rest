package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.library;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;

import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserMenager;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "library")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Library {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String city;
    private String email;
    private String latitude;
    private String local;
    private String longitude;
    private String name;
    private String number;
    private String postalCode;
    private String street;

    @OneToMany(mappedBy = "library",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Book> bookList=new ArrayList<>();

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserMenager userMenager;

}
