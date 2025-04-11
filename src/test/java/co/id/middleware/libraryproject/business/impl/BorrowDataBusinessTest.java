package co.id.middleware.libraryproject.business.impl;

import co.id.middleware.libraryproject.business.BorrowDataBusiness;
import co.id.middleware.libraryproject.model.BorrowData;
import co.id.middleware.libraryproject.repository.BorrowDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BorrowDataBusinessTest {

    private BorrowDataBusiness borrowDataBusiness = new BorrowDataBusinessImpl();

    @Mock
    private BorrowDataRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ReflectionTestUtils.setField(borrowDataBusiness, "repository", repository);
    }

    @Test
    public void findBorrowDataByBookId() {
        when(repository.findByBookId(any(UUID.class))).thenReturn(this.getBorrowData());
        var resp = borrowDataBusiness.findBorrowDataByBookId(UUID.fromString("45672cc2-afaa-4a05-a355-34c6cff2a57a"));
        verify(repository, times(1)).findByBookId(any(UUID.class));
        assertEquals(resp.getBookId(), this.getBorrowData().getBookId());
        assertEquals(resp.getBookName(), this.getBorrowData().getBookName());
        assertEquals(resp.getLoanName(), this.getBorrowData().getLoanName());
        assertEquals(resp.getLoanAddress(), this.getBorrowData().getLoanAddress());
    }

    @Test
    public void saveBorrowData() {
        borrowDataBusiness.save(this.getBorrowData());
        verify(repository, times(1)).save(any(BorrowData.class));
    }

    private BorrowData getBorrowData() {
        BorrowData borrowData = new BorrowData();
        borrowData.setId(UUID.fromString("45672cc2-afaa-4a05-a355-34c6cff2a57a"));
        borrowData.setBookId(UUID.fromString("45672cc2-afaa-4a05-a355-34c6cff2a572"));
        borrowData.setLoanName("loanName");
        borrowData.setLoanAddress("loanAddress");
        borrowData.setBookName("bookName");
        borrowData.setCreatedDate(new Date());
        borrowData.setUpdatedDate(new Date());
        borrowData.setLoanDate(new Date());
        borrowData.setLoanReturnDate(new Date());
        borrowData.setLoanStatus("RETURN");
        return borrowData;
    }

}
