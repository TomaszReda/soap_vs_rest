package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Model BookCategory for SOAP and REST . .
 * @author Tomasz Reda
 * */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryType;

}
