package id.co.bpddiy.testservice.service;

import id.co.bpddiy.testservice.domain.dao.Book;
import id.co.bpddiy.testservice.domain.dto.BookDto;
import id.co.bpddiy.testservice.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(BookDto request) {
        Book book = Book.builder()
                .title(request.getTitle())
                .price(request.getPrice())
                .build();
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        log.info("start getbook");

        List<Book> bookList = bookRepository.findAll();

        log.info("response db book list "+bookList);

        return bookRepository.findAll();
    }
}
