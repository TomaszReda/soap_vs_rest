package pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.task.TaskForLibrary;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.task.TaskStatus;


import java.util.UUID;

@RepositoryRestResource
public interface TaskForLibraryRepository extends JpaRepository<TaskForLibrary, UUID> {


}
