package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.request.BookAddResponse;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service.BookService;

@Controller("/api")
public class BookController {

    @Autowired
    BookService bookService = new BookService();

    @ResponseBody
    @GetMapping("/add/book")
    public String add() {
        BookAddResponse bookAddResponse = new BookAddResponse();

        return bookAddResponse.toString();
    }
}
