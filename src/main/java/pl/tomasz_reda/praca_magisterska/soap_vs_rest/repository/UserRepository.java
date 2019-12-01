package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;

import java.util.UUID;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, UUID>, QuerydslPredicateExecutor<User> {
//
//    @Override
//    default public void customize(QuerydslBindings bindings, QUser root) {
//        bindings.bind(String.class).first(
//                (StringPath path, String value) -> path.containsIgnoreCase(value));
//        bindings.excluding(root.email);
//    }

}
