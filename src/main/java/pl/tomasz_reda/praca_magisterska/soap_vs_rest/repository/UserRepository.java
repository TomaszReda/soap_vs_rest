package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserCasual;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserMenager;

import java.util.UUID;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, UUID> {

    User findUserByEmail(String email);

    User findAllByUserMenager(UserMenager userMenager);

    Page<User> findAllByEmailContains(String word,Pageable pageable);

    User findUserByResetPasswordToken(UUID uuid);

    User findByUserCasual(UserCasual userCasual);
}
