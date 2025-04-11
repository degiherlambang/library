package co.id.middleware.libraryproject.business.impl;

import co.id.middleware.libraryproject.business.BorrowDataBusiness;
import co.id.middleware.libraryproject.model.BorrowData;
import co.id.middleware.libraryproject.repository.BorrowDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class BorrowDataBusinessImpl implements BorrowDataBusiness {

    @Autowired
    private BorrowDataRepository repository;

    @Override
    public BorrowData findBorrowDataByBookId(UUID id) {
        log.info("{}.findBorrowDataByBookId: {}", this.getClass().getSimpleName(), id);
        return repository.findByBookId(id);
    }

    @Override
    public void save(BorrowData borrowData) {
        log.info("{}.save: {}", this.getClass().getSimpleName(), borrowData);
        repository.save(borrowData);
    }


}
