package co.id.middleware.libraryproject.service.impl;

import co.id.middleware.libraryproject.business.BorrowDataBusiness;
import co.id.middleware.libraryproject.model.Book;
import co.id.middleware.libraryproject.model.BorrowData;
import co.id.middleware.libraryproject.service.ProcessLibraryCommon;
import co.id.middleware.libraryproject.utility.ObjectMapperUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Date;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BorrowBookReturnImplTest {

    private ProcessLibraryCommon processLibraryCommon = new BorrowBookReturnImpl();

    @Mock
    private BorrowDataBusiness business;

    @Mock
    private ObjectMapperUtil mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(processLibraryCommon, "business", business);
        ReflectionTestUtils.setField(processLibraryCommon, "mapper", mapper);
    }

    @Test
    public void process() throws Exception {
        when(mapper.deserialize(any(), any())).thenReturn(getBorrowData());
        when(business.findBorrowDataByBookId((UUID)(any()))).thenReturn(getBorrowData());
        var resp = processLibraryCommon.process(new HttpEntity<String>(""));
        verify(mapper, times(1)).deserialize(any(), any());
        verify(business, times(1)).findBorrowDataByBookId((UUID)(any()));
        verify(business, times(1)).save((any()));
    }

    @Test
    public void processIfException() throws Exception {
        when(mapper.deserialize(any(), any())).thenReturn(null);
        var resp = processLibraryCommon.process(new HttpEntity<String>(""));
        verify(mapper, times(1)).deserialize(any(), any());
        verify(business, times(0)).findBorrowDataByBookId((UUID)(any()));
        verify(business, times(0)).save((any()));
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
