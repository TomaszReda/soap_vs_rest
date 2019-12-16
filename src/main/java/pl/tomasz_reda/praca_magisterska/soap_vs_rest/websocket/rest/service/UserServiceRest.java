package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service;

import org.springframework.data.domain.Pageable;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.UserDto;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.mapper.UserMapper;

import java.util.Optional;

@Service
public class UserServiceRest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public ResponseEntity add(@RequestBody UserDto userDto) {
        User user = userMapper.ResttoUser(userDto);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity edit(@RequestBody UserDto userDto) {
        Optional<User> userExsist = userRepository.findById(userDto.getId());
        if (userExsist.isPresent()) {
            User user = userMapper.ResttoUser(userDto);
            userRepository.save(user);
        }
        return ResponseEntity.ok().build();

    }

    public ResponseEntity<Page<User>> find(Pageable pageable, Predicate predicate) {

        if (predicate == null) {
            return ResponseEntity.ok(userRepository.findAll(pageable));
        } else
            return ResponseEntity.ok(userRepository.findAll(predicate, pageable));
    }
}
