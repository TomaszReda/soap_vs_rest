package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.UserDto;


@Mapper(componentModel ="spring",injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {
    User toUser(UserDto userDto);

    UserDto toUserDto(User user);
}
