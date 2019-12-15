package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.querydsl.core.types.Predicate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.BookRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.dto.BookDto;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.mapper.BookMapper;

import java.util.Optional;

@Service
public class BookServiceRest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public ResponseEntity add(@RequestBody BookDto bookDto) {
        Book book = bookMapper.toBook(bookDto);
        bookRepository.save(book);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity delete(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity edit(@RequestBody BookDto BookDto) {
        Book book = bookMapper.toBook(BookDto);
        bookRepository.save(book);
        return ResponseEntity.ok().build();

    }

    public ResponseEntity<Page<Book>> find(Pageable pageable, Predicate predicate) {

        if (predicate == null) {
            return ResponseEntity.ok(bookRepository.findAll(pageable));
        } else
            return ResponseEntity.ok(bookRepository.findAll(predicate, pageable));
    }
}
