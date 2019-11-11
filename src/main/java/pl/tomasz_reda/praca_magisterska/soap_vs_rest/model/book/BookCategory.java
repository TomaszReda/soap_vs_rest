package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryType;

    public BookCategory(String categoryType) {
        this.categoryType = categoryType;
    }

    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();
}
