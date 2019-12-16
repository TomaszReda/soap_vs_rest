package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.mapper;

import org.mapstruct.Context;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.BookCategory;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.BookDto;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.UserDto;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface BookMapper {

    Book ResttoBook(BookDto bookDto);

    Book SoapAddBookRequestToBook(soap.AddBookRequest addBookRequest);

    Book SoapEditBookRequestToBook(soap.EditBookRequest editBookRequest);

    List<soap.Book> convertToBookList(List<Book> books);
}
