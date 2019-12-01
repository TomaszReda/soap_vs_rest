package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRoleRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.UserDto;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.mapper.UserMapper;

import java.util.UUID;

@Service
public class UserService {

//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    public void addUser(@RequestBody UserDto userDto) {
//        User user = userMapper.toUser(userDto);
//        userRepository.save(user);
//    }
//
//    public void delete(UUID id) {
//        User user = userRepository.findById(id).get();
//        if (user != null) {
//            userRepository.delete(user);
//        }
//    }
//
//    public void edit(@RequestBody UserDto userDto) {
//        User user = userMapper.toUser(userDto);
//        userRepository.save(user);
//    }
//
//    public Page<User> find(Pageable pageable, @RequestParam String userName) {
//
//    }
}
