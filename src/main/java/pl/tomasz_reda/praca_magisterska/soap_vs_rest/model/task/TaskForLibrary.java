package pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.library.Library;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.message.MessageToLibraryOwner;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Getter
@Setter
public class TaskForLibrary extends Task {

    @Enumerated(value = EnumType.STRING)
    private TaskForLibraryType taskForLibraryType;

    @OneToOne(mappedBy = "taskForLibrary")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private MessageToLibraryOwner messageToLibraryOwner;


    public TaskForLibrary(User toUser, LocalDateTime dateCreate, LocalDateTime dateExpiration, TaskStatus taskStatus, Book book, Library library, TaskForLibraryType taskForLibraryType) {
        super(toUser, dateCreate, dateExpiration, taskStatus, book, library);
        this.taskForLibraryType = taskForLibraryType;
    }

    @Override
    public String toString() {
        return "TaskForLibrary{" +
                super.toString() +
                "taskForLibraryType=" + taskForLibraryType +
                ", messageToLibraryOwner=" + messageToLibraryOwner +
                '}';
    }
}
