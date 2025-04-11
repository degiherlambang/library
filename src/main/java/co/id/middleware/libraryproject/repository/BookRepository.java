package co.id.middleware.libraryproject.repository;

import co.id.middleware.libraryproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    @Query(value = "SELECT * FROM BOOK " +
            "OFFSET :page ROWS " +
            "FETCH NEXT :pageSize ROWS ONLY", nativeQuery = true)
    List<Book> findByPage(@Param("page") String page, @Param("pageSize") String pageSize);

}
