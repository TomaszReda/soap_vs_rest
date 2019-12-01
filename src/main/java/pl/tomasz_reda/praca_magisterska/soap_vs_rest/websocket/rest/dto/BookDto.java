package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.BookCategory;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.BookState;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class BookDto {
    private Long id;

    private String author;

    private String title;

    private String publisher;

    private LocalDate date;

    private String isbn;

    private int quant;

    private String bookSearch;

    private String description;

    private BookState bookState;

    private Set<BookCategory> bookCategory=new HashSet<>();
}
