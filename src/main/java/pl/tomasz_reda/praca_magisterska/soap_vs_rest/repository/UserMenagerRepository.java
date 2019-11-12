package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserMenager;

import java.util.UUID;

@RepositoryRestResource
public interface UserMenagerRepository  extends JpaRepository<UserMenager, Long> {
}
