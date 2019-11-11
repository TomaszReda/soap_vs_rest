package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.library.Library;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.message.MessageToLibraryOwner;


import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface MessageToLibraryOwnerRepository extends JpaRepository<MessageToLibraryOwner, UUID> {

    List<MessageToLibraryOwner> findAllByLibraryAndDateReadIsNullOrderByDataCreateDesc(Library library);

    List<MessageToLibraryOwner> findAllByDateReadIsNull();
}
