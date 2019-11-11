package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.library.Library;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserMenager;


import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface LibraryRepository extends JpaRepository<Library, UUID> {
    Page<Library> findAllByNameContains(String name, Pageable pageable);
    List<Library> findAllByUserMenager(UserMenager userMenager);
}
