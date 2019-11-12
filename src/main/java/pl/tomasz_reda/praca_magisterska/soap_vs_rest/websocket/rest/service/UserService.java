package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserCasual;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserRoleEnum;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.UserRoles;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserCasualRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRoleRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.request.AddUserResponse;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserCasualRepository userCasualRepository;

    public String addUser(int ile) {
        UserRoles userRoles = new UserRoles();
        userRoles.setUserRole(UserRoleEnum.CASUAL_USER);
        userRoles = userRoleRepository.save(userRoles);
        AddUserResponse addUserResponse = new AddUserResponse();
        UserCasual userCasual=new UserCasual();
        userCasual = userCasualRepository.save(userCasual);

        for (int i = 0; i < ile; i++) {
            User user = new User("tomek", "reda", "tomekreda@op.pl", 533927396, "GHJbnm123", null, userCasual, userRoles);
            userRepository.save(user);
            addUserResponse.getUser().add(user);
        }

        System.err.println(addUserResponse.toString());
        return addUserResponse.toString();
    }
}
