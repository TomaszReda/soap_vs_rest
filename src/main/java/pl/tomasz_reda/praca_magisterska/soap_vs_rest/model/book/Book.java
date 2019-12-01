package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String title;

    private String publisher;

    private LocalDate date;

    private String isbn;

    private int quant;

    private String bookSearch;

    @Column(length = 4096)
    private String description;

    @Enumerated(EnumType.STRING)
    private BookState bookState;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private BookCategory bookCategory;

}
