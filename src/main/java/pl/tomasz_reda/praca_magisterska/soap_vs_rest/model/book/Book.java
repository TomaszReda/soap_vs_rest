package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import pl.tomekreda.library.model.library.Library;
import pl.tomekreda.library.model.task.Task;
import pl.tomekreda.library.model.user.UserCasual;
import pl.tomekreda.library.model.user.UserMenager;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String author;
    private String title;
    private String publisher;
    private LocalDate date;
    private String isbn;
    private int quant;

    private String bookSearch;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Task> task;

    @Column(length = 4096)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Library library;

    @Enumerated(EnumType.STRING)
    private BookState bookState;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserCasual userCasual;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserMenager userMenager;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private BookCategory bookCategory;

    public Book(String author, String title, String publisher, LocalDate date, String isbn, int quant) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.date = date;
        this.isbn = isbn;
        this.quant = quant;
    }



    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", date=" + date +
                ", isbn='" + isbn + '\'' +
                ", quant=" + quant +
                ", description='" + description + '\'' +
                ", bookState=" + bookState +
                '}';
    }
}
