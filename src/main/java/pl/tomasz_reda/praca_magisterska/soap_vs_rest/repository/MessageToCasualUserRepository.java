package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.message.MessageToCasualUser;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;


import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface MessageToCasualUserRepository extends JpaRepository<MessageToCasualUser, UUID> {

    List<MessageToCasualUser> findAllByUserAndDateReadIsNullOrderByDataCreateDesc(User user);

    List<MessageToCasualUser> findAllByDateReadIsNull();
}
