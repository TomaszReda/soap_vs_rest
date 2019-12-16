package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`book`")
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

    @ManyToMany
    @JoinTable(
            name = "book_book_category",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<BookCategory> bookCategory = new ArrayList<>();

}
