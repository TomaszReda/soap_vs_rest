package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.service.UserServiceSoap;



@Endpoint
public class UserControllerSoap {
    private static final String NAMESPACE_URI = "https://www.praca_magister/soap_vs_rest/users.com";

    @Autowired
    private UserServiceSoap userServiceSoap;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteUserRequest")
    public void deleteUser(@RequestPayload soap.DeleteUserRequest request) {
        userServiceSoap.deleteUser(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddUserRequest")
    public void addUser(@RequestPayload soap.AddUserRequest request) {
        userServiceSoap.addUser(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EditUserRequest")
    public void editUser(@RequestPayload soap.EditUserRequest request) {
        userServiceSoap.editUser(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserRequest")
    @ResponsePayload
    public soap.GetUserResponse getUser(@RequestPayload soap.GetUserRequest request) {

        return userServiceSoap.getUser(request);
    }

}