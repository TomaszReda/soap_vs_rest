package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.service.UserServiceSoap;
import soap.AddUserRequest;
import soap.DeleteUserRequest;

@Endpoint
public class UserControllerSoap {


    private static final String NAMESPACE_URI = "https://www.howtodoinjava.com/xml/school";

    @Autowired
    private UserServiceSoap userServiceSoap;

    @PayloadRoot(localPart = NAMESPACE_URI,namespace = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserRequest delete(@RequestPayload soap.DeleteUserRequest deleteUserRequest) {
        return deleteUserRequest;
    }


    @PayloadRoot(localPart = NAMESPACE_URI,namespace = "addUserRequest")
    @ResponsePayload
    public AddUserRequest delete(@RequestPayload soap.AddUserRequest addUserRequest) {
        return addUserRequest;
    }
//    @PayloadRoot(localPart = "http:localhost:8080/api/user/delete")
//    public void addUser(@RequestPayload soap.AddUserRequest addUserRequest) {
//        System.err.println(addUserRequest);
//    }
//
//    @PayloadRoot(localPart = "edit")
//    @ResponsePayload
//    public void edit() {
//
//    }
//
//    @PayloadRoot(localPart = "find")
//    @ResponsePayload
//    public void find() {
//
//    }
}
