package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;

import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.QUser;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;


@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {

    @Override
    default public void customize(QuerydslBindings bindings, QUser root) {
        bindings.bind(String.class).first(
                (StringPath path, String value) -> path.containsIgnoreCase(value));
    }

    Page<User> findAllByFirstnameContains(String firstname, Pageable pageable);

    Page<User> findAllByLastnameContains(String lastName, Pageable pageable);

    Page<User> findAllByFirstnameContainsOrLastnameContains(String firstname, String lastname, Pageable pageable);

    User findUserByEmail(String email);
}
