package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.message.Message;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
}
