package co.id.middleware.libraryproject.business.impl;


import co.id.middleware.libraryproject.business.BookBusiness;
import co.id.middleware.libraryproject.model.Book;
import co.id.middleware.libraryproject.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookBusinessImplTest {

    private BookBusiness bookBusiness = new BookBusinessImpl();

    @Mock
    private BookRepository repository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        ReflectionTestUtils.setField(bookBusiness, "repository", repository);

    }

    @Test
    public void findBookById() {
        when(this.repository.findById((UUID) any())).thenReturn(Optional.of(this.getBook1()));
        var resp = bookBusiness.findBookById(UUID.fromString("45672cc2-afaa-4a05-a355-34c6cff2a57a"));
        verify(repository, times(1)).findById((UUID) any());
        assertEquals(resp.getName(), this.getBook1().getName());
        assertEquals(resp.getAuthor(), this.getBook1().getAuthor());
        assertEquals(resp.getDescription(), this.getBook1().getDescription());
    }

    @Test
    public void findBookWithPage() {
        when(this.repository.findByPage(anyString(), anyString())).thenReturn(this.listBooks());
        var resp = bookBusiness.findBookWithPage(anyString(), anyString());
        verify(repository, times(1)).findByPage(anyString(), anyString());
        var resultBook1 = resp.get(0);
        var resultBook2 = resp.get(1);
        assertEquals(resultBook1.getName(), this.getBook1().getName());
        assertEquals(resultBook1.getAuthor(), this.getBook1().getAuthor());
        assertEquals(resultBook1.getDescription(), this.getBook1().getDescription());
        assertEquals(resultBook2.getName(), this.getBook2().getName());
        assertEquals(resultBook2.getAuthor(), this.getBook2().getAuthor());
        assertEquals(resultBook2.getDescription(), this.getBook2().getDescription());
    }

    @Test
    public void saveBook() {
        bookBusiness.save(this.getBook1());
        verify(repository, times(1)).save(any());
    }

    private Book getBook1() {
        Book book = new Book();
        book.setId(UUID.fromString("45672cc2-afaa-4a05-a355-34c6cff2a57a"));
        book.setAuthor("Author1");
        book.setName("Book1");
        book.setDescription("Description1");
        book.setCreatedDate(new Date());
        book.setPublishDate(new Date());
        return book;
    }

    private Book getBook2() {
        Book book = new Book();
        book.setId(UUID.fromString("45672cc2-afaa-4a05-a355-34c6cff2a57b"));
        book.setAuthor("Author2");
        book.setName("Book2");
        book.setDescription("Description2");
        book.setCreatedDate(new Date());
        book.setPublishDate(new Date());
        return book;
    }

    private List<Book> listBooks() {
        List<Book> list = new ArrayList<>();
        list.add(this.getBook1());
        list.add(this.getBook2());
        return list;
    }

}
