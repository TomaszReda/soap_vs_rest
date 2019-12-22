package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.controller;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.BookCategoryRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.BookDto;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service.BookServiceRest;

@Controller
@RequestMapping("/api/rest/book")
public class BookControllerRest {

    @Autowired
    private BookServiceRest bookService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody BookDto bookDto) {
        return bookService.add(bookDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return bookService.delete(id);
    }

    @PutMapping("/edit")
    public ResponseEntity edit(@RequestBody BookDto bookDto) {
        return bookService.edit(bookDto);
    }

    @GetMapping("/find")
    public ResponseEntity<Page<Book>> find(Pageable pageable, Predicate predicate) {
        return bookService.find(pageable, predicate);
    }


}

