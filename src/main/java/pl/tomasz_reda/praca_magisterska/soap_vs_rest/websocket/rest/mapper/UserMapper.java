package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.mapper;

import org.mapstruct.Mapper;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.UserDto;

import javax.jws.soap.SOAPBinding;

@Mapper
public interface UserMapper {
    User toUser(UserDto userDto);

    UserDto toUserDto(User user);
}
