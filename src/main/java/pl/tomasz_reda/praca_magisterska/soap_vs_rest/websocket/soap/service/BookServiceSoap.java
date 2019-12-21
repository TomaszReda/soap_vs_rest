package pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.soap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.model.book.Book;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.BookCategoryRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.repository.BookRepository;
import pl.tomasz_reda.praca_magisterska.soap_vs_rest.websocket.rest.mapper.BookMapper;
import soap.FindBookCategoryResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceSoap {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    private BookMapper bookMapper;

    public void deleteBook(soap.DeleteBookRequest request) {
        Optional<Book> book = bookRepository.findById(request.getId());
        if (book.isPresent()) {
            bookRepository.delete(book.get());
        }
    }

    public soap.FindBookCategoryResponse findBookCAtegory() {
        soap.FindBookCategoryResponse findBookCategoryResponse=new FindBookCategoryResponse();
        findBookCategoryResponse.getBookCategory().addAll(
                bookMapper.toBookCategoryList(bookCategoryRepository.findAll())
        );
        return findBookCategoryResponse;
    }

    public void addBook(soap.AddBookRequest request) {
        Book book = bookMapper.SoapAddBookRequestToBook(request);
        LocalDate localDate = LocalDate.of(
                request.getData().getYear(),
                request.getData().getMonth(),
                request.getData().getDay());
        book.setDate(localDate);
        bookRepository.save(book);
    }

    public void editBook(soap.EditBookRequest request) {
        Optional<Book> bookExsist = bookRepository.findById(request.getId());
        if (bookExsist.isPresent()) {
            Book book = bookMapper.SoapEditBookRequestToBook(request);
            LocalDate localDate = LocalDate.of(
                    request.getData().getYear(),
                    request.getData().getMonth(),
                    request.getData().getDay());
            book.setDate(localDate);
            bookRepository.save(book);
        }
    }

    public soap.GetBookResponse getBook(soap.GetBookRequest request) {
        Page<Book> books;
        PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize());
        if (!checkIsNullOrEmpty(request.getAuthor()) && !checkIsNullOrEmpty(request.getTitle())) {
            books = bookRepository.findAllByAuthorContainsOrTitleContains(request.getTitle(), request.getAuthor(), pageRequest);
        } else if (!checkIsNullOrEmpty(request.getAuthor()) && checkIsNullOrEmpty(request.getTitle())) {
            books = bookRepository.findAllByAuthorContains(request.getAuthor(), pageRequest);
        } else if (checkIsNullOrEmpty(request.getAuthor()) && !checkIsNullOrEmpty(request.getTitle())) {
            books = bookRepository.findAllByTitleContains(request.getTitle(), pageRequest);
        } else {
            books = bookRepository.findAll(pageRequest);
        }
        soap.GetBookResponse getBookResponse = convertPageableToBook(books);
        return getBookResponse;
    }

    private boolean checkIsNullOrEmpty(String value) {
        return value.equals(null) || value == null || value.equals("") || value == "";
    }


    private soap.GetBookResponse convertPageableToBook(Page<Book> books) {
        soap.GetBookResponse getBookResponse = new soap.GetBookResponse();
        getBookResponse.setNumberOfElements(books.getNumberOfElements());
        getBookResponse.setSize(books.getSize());
        getBookResponse.setTotalPages(books.getTotalPages());
        getBookResponse.setNumber(books.getNumber());
        getBookResponse.setTotalElements(books.getTotalElements());
        List<soap.Book> booksList = bookMapper.convertToBookList(books.getContent());
        getBookResponse.getBook().addAll(booksList);
        return getBookResponse;
    }

}
