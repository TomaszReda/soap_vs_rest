package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.UserDto;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service.UserService;

import java.util.UUID;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

//
//    @PostMapping("/add")
//    public void addUser(@RequestBody UserDto userDto) {
//        userService.addUser(userDto);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void delete(UUID id) {
//        userService.delete(id);
//    }
//
//    @PutMapping("/edit")
//    public void edit(@RequestBody UserDto userDto) {
//        userService.edit(userDto);
//    }
//
//    @GetMapping("find")
//    public Page<User> find(Pageable pageable, @RequestParam(defaultValue = "") String userName) {
//        return userService.find(pageable, userName);
//    }


}
