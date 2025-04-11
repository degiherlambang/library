package co.id.middleware.libraryproject.business;

import co.id.middleware.libraryproject.model.BorrowData;

import java.util.UUID;

public interface BorrowDataBusiness {


    public BorrowData findBorrowDataByBookId(UUID id);

    public void save(BorrowData borrowData);

}
