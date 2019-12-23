package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.TestDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rest")
public class TestControllerRest {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/test")
    public List<TestDto> test(@RequestBody TestDto testDto) {

        List<TestDto> testDtos=new ArrayList<>();
        testDtos.add(testDto);
        testDtos.add(testDto);
        return testDtos;
    }

}
