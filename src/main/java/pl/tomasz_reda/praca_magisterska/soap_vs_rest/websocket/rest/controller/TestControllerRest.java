package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.TestDto;

@RestController
@RequestMapping("/api/rest")
public class TestControllerRest {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/test")
    public void test(@RequestBody TestDto testDto) {
        System.err.println("rest");
    }

}
