package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.config.CacheConfiguration;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.BookCategory;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.BookCategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/rest/book-category")
@Slf4j
public class BookCategoryRest {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Cacheable(CacheConfiguration.CACHE_BOOK_CATEGORY)
    @GetMapping("/find")
    public ResponseEntity<List<BookCategory>> bookCategory() {
        log.info("Cache");
        return ResponseEntity.ok(bookCategoryRepository.findAll());
    }
}
