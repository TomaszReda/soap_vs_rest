package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.user.User;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.UserRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.mapper.UserMapper;
import soap.GetUserResponse;
import soap.ObjectFactory;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceSoap {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public void deleteUser(soap.DeleteUserRequest request) {
        Optional<User> user = userRepository.findById(request.getId());
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }

    }

    public void addUser(soap.AddUserRequest request) {
        User user = userMapper.SoapAddUserRequestToUser(request);
        userRepository.save(user);
    }

    public void editUser(soap.EditUserRequest request) {
        Optional<User> userExsist = userRepository.findById(request.getId());
        if (userExsist.isPresent()) {
            User user = userMapper.SoapEditUserRequestToUser(request);
            userRepository.save(user);
        }
    }


    public soap.GetUserResponse getUser(soap.GetUserRequest request) {
        Page<User> users;
        PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize());
        if (!checkIsNullOrEmpty(request.getLastname()) && !checkIsNullOrEmpty(request.getFirstname())) {
            users = userRepository.findAllByFirstnameContainsAndLastnameContains(request.getFirstname(), request.getLastname(), pageRequest);
        } else if (!checkIsNullOrEmpty(request.getLastname()) && checkIsNullOrEmpty(request.getFirstname())) {
            users = userRepository.findAllByLastnameContains(request.getLastname(), pageRequest);
        } else if (checkIsNullOrEmpty(request.getLastname()) && !checkIsNullOrEmpty(request.getFirstname())) {
            users = userRepository.findAllByFirstnameContains(request.getFirstname(), pageRequest);
        } else {
            users = userRepository.findAll(pageRequest);
        }
        soap.GetUserResponse getUserResponse = convertPageableToUser(users);
        return getUserResponse;
    }

    private boolean checkIsNullOrEmpty(String value) {
        return value.equals(null) || value == null || value.equals("") || value == "";
    }


    private GetUserResponse convertPageableToUser(Page<User> users) {
        GetUserResponse getUserResponse = new GetUserResponse();
        getUserResponse.setNumberOfElements(users.getNumberOfElements());
        getUserResponse.setSize(users.getSize());
        getUserResponse.setTotalPages(users.getTotalPages());
        getUserResponse.setNumber(users.getNumber());
        getUserResponse.setTotalElements(users.getTotalElements());
        List<soap.User> usersList = userMapper.convertToUserList(users.getContent());
        getUserResponse.getUser().addAll(usersList);
        return getUserResponse;
    }
}
