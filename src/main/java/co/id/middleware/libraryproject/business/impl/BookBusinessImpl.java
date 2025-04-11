package co.id.middleware.libraryproject.business.impl;

import co.id.middleware.libraryproject.business.BookBusiness;
import co.id.middleware.libraryproject.model.Book;
import co.id.middleware.libraryproject.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class BookBusinessImpl implements BookBusiness {

    @Autowired
    private BookRepository repository;


    @Override
    public Book findBookById(UUID id) {
        log.info("{}.findBookById: {}", this.getClass().getSimpleName(), id);
        return repository.findById(id).get();
    }

    @Override
    public List<Book> findBookWithPage(String page, String pageSize) {
        log.info("{}.findBookWithPage: {},{}", this.getClass().getSimpleName(), page, pageSize);
        return repository.findByPage(page, pageSize);
    }

    @Override
    public void save(Book book) {
        log.info("{}.save: {}", this.getClass().getSimpleName(), book);
        repository.save(book);
    }
}
