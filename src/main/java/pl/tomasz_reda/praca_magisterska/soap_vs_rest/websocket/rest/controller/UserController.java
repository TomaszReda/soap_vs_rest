package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.controller;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.UserDto;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service.UserService;


@Controller
@RequestMapping("/api/rest/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @PutMapping("/edit")
    public ResponseEntity edit(@RequestBody UserDto userDto) {
        return userService.edit(userDto);
    }

    @GetMapping("/find")
    public ResponseEntity<Page<User>> find(Pageable pageable, Predicate predicate) {
        return userService.find(pageable, predicate);
    }


}