package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.library.Library;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserMenager {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "userMenager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Library> libraryList = new ArrayList<>();



}


