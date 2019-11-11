package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.message.Message;

import java.util.UUID;

@RepositoryRestResource
public interface MessageRepository extends JpaRepository<Message, UUID> {
}
