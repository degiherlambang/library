package co.id.middleware.libraryproject.service.impl;

import co.id.middleware.libraryproject.business.BookBusiness;
import co.id.middleware.libraryproject.model.Book;
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

public class RegisBookImplTest {

    private ProcessLibraryCommon processLibraryCommon = new RegisBookImpl();

    @Mock
    private BookBusiness business;

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
        when(mapper.deserialize(any(), any())).thenReturn(getBook1());
        var resp = processLibraryCommon.process(new HttpEntity<String>(""));
        verify(mapper, times(1)).deserialize(any(), any());
        verify(business, times(1)).save(any());
    }

    @Test
    public void processIfException() throws Exception {
        when(mapper.deserialize(any(), any())).thenReturn(null);
        var resp = processLibraryCommon.process(new HttpEntity<String>(""));
        verify(mapper, times(1)).deserialize(any(), any());
        verify(business, times(0)).save(any());
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

}
