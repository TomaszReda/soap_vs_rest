package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.BookState;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.library.Library;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserCasual;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserMenager;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, UUID> {


}


