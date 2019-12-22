package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRepository;
import soap.DeleteUserRequest;

import java.util.Optional;


@RestController
@RequestMapping("/api/")
public class RestSoapController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("rest_to_soap/delete/user/{id}")
    public void a(@RequestBody DeleteUserRequest deleteUserRequest) throws Exception {
        Optional<User> user = userRepository.findById(deleteUserRequest.getId());
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
    }
}
