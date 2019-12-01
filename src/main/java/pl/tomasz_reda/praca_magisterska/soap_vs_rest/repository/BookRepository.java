package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;

import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.QBook;

import java.util.UUID;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Long>, QuerydslPredicateExecutor<Book>, QuerydslBinderCustomizer<QBook> {

    @Override
    default public void customize(QuerydslBindings bindings, QBook root) {
        bindings.bind(String.class).first(
                (StringPath path, String value) -> path.containsIgnoreCase(value));
    }

}



