package co.id.middleware.libraryproject.repository;

import co.id.middleware.libraryproject.model.BorrowData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BorrowDataRepository extends JpaRepository<BorrowData, UUID> {

    BorrowData findByBookId(UUID bookId);

    BorrowData findByBookName(String bookName);
}
