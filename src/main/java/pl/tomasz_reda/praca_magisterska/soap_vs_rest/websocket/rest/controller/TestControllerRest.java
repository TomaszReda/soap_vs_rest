package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.TestDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rest")
public class TestControllerRest {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/test/send-and-receiv")
    public List<TestDto> test(@RequestBody TestDto testDto) {
        List<TestDto> testDtos=new ArrayList<>();
        testDtos.add(testDto);
        testDtos.add(testDto);
        testDtos.add(testDto);
        return testDtos;
    }


    @PostMapping("/test/send-only")
    public void test2(@RequestBody TestDto testDto) {
    }

}
