package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.service.BookServiceSoap;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.service.UserServiceSoap;

public class BookControllerSoap {
//
//    private static final String NAMESPACE_URI = "https://www.praca_magister/soap_vs_rest/users.com";
//
//    @Autowired
//    private BookServiceSoap bookServiceSoap;
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteBookRequest")
//    public void deleteUser(@RequestPayload soap.DeleteBookRequest request) {
//        bookServiceSoap.deleteBook(request);
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddBookRequest")
//    public void addUser(@RequestPayload soap.AddBookRequest request) {
//        bookServiceSoap.addBook(request);
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EditBookRequest")
//    public void editUser(@RequestPayload soap.EditBookRequest request) {
//        bookServiceSoap.editBook(request);
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBookRequest")
//    @ResponsePayload
//    public soap.GetBookResponse getUser(@RequestPayload soap.GetBookRequest request) {
//        return bookServiceSoap.getBook(request);
//    }
}
