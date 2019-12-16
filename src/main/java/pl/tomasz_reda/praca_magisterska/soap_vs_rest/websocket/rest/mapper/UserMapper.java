package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.BookCategory;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.UserDto;

import java.util.List;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {
    User ResttoUser(UserDto userDto);

    User SoapAddUserRequestToUser(soap.AddUserRequest addUserRequest);

    User SoapEditUserRequestToUser(soap.EditUserRequest addUserRequest);

    List<soap.User> convertToUserList(List<User> users);
//    soap.GetUserResponse SoapPageToGetUserResponse(Page<User> users);
}
