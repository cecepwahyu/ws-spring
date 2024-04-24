package id.co.bpddiy.testservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import id.co.bpddiy.testservice.domain.dao.Book;
import id.co.bpddiy.testservice.repository.BookRepository;

@SpringBootTest
@ContextConfiguration(classes = BookService.class)
public class BookServiceTest {

    @MockBean
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @Test
    void getBook_SuccessTest() {
        List<Book> bookList = List.of(Book.builder().price(12000).title("Sinta Gabut").build());

        // Mock the behavior of bookRepository.findAll() to return the predefined bookList
        when(bookRepository.findAll()).thenReturn(bookList);

        // Call the method under test
        List<Book> bookListResponse = bookService.getBooks();

        // Assert that the response is not null and matches the predefined bookList
        assertNotNull(bookListResponse);
        assertEquals(bookList, bookListResponse);
    }

    @Test
    void getBook_ThrowsTest() {
        // Mock the behavior of bookRepository.findAll() to throw a RuntimeException
        when(bookRepository.findAll()).thenThrow(new RuntimeException());

        // Assert that the method under test throws a RuntimeException
        assertThrows(RuntimeException.class, () -> {
            bookService.getBooks();
        });
    }
}
