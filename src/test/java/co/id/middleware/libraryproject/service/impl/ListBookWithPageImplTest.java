package co.id.middleware.libraryproject.service.impl;

import co.id.middleware.libraryproject.business.BookBusiness;
import co.id.middleware.libraryproject.model.Book;
import co.id.middleware.libraryproject.model.dto.RequestRestListPage;
import co.id.middleware.libraryproject.service.ProcessLibraryCommon;
import co.id.middleware.libraryproject.utility.ObjectMapperUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ListBookWithPageImplTest {

    private ProcessLibraryCommon processLibraryCommon = new ListBookWithPageImpl();

    @Mock
    private BookBusiness business;

    @Mock
    private ObjectMapperUtil mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(processLibraryCommon, "mapper", mapper);
        ReflectionTestUtils.setField(processLibraryCommon, "business", business);
    }

    @Test
    public void process() throws Exception {
        when(mapper.deserialize(any(), any())).thenReturn(restListPage());
        when(business.findBookWithPage(any(), any())).thenReturn(listBooks());
        var resp = processLibraryCommon.process(new HttpEntity<String>(""));
        verify(mapper, times(1)).deserialize(any(), any());
        verify(business, times(1)).findBookWithPage(any(), any());
    }

    @Test
    public void processIfNull() throws Exception {
        when(mapper.deserialize(any(), any())).thenReturn(null);
        when(business.findBookWithPage(any(), any())).thenReturn(listBooks());
        var resp = processLibraryCommon.process(new HttpEntity<String>(""));
        verify(mapper, times(1)).deserialize(any(), any());
    }

    @Test
    public void processIfExeception() throws Exception {
        when(mapper.deserialize(any(), any())).thenThrow(new RuntimeException());
        var resp = processLibraryCommon.process(new HttpEntity<String>(""));
    }


    private RequestRestListPage restListPage() {
        RequestRestListPage listPage = new RequestRestListPage();
        listPage.setPage(1);
        listPage.setPageSize(2);
        return listPage;
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
