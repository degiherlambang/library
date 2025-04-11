package co.id.middleware.libraryproject.business;

import co.id.middleware.libraryproject.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookBusiness {

    public Book findBookById(UUID id);

    public List<Book> findBookWithPage(String page, String pageSize);

    public void save(Book book);

}
