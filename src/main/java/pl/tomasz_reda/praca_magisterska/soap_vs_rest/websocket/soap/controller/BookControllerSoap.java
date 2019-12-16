package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.service.BookServiceSoap;

@Endpoint
public class BookControllerSoap {

    private static final String NAMESPACE_URI = "https://www.praca_magister/soap_vs_rest/books.com";

    @Autowired
    private BookServiceSoap bookServiceSoap;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteBookRequest")
    public void deleteBook(@RequestPayload soap.DeleteBookRequest request) {
        bookServiceSoap.deleteBook(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddBookRequest")
    public void addBook(@RequestPayload soap.AddBookRequest request) {
        bookServiceSoap.addBook(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EditBookRequest")
    public void editBook(@RequestPayload soap.EditBookRequest request) {
        bookServiceSoap.editBook(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBookRequest")
    @ResponsePayload
    public soap.GetBookResponse getBook(@RequestPayload soap.GetBookRequest request) {
        return bookServiceSoap.getBook(request);
    }
}
