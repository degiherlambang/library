package co.id.middleware.libraryproject.controller;

import co.id.middleware.libraryproject.service.ProcessLibraryCommon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

public class LibraryControllerTest {

    private LibraryController libraryController = new LibraryController();

    @Mock
    private ProcessLibraryCommon service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(libraryController, "regisService", service);
        ReflectionTestUtils.setField(libraryController, "borrowService", service);
        ReflectionTestUtils.setField(libraryController, "returnService", service);
        ReflectionTestUtils.setField(libraryController, "listBookService", service);
    }

    @Test
    public void registerBook() {
        when(service.process((HttpEntity<String>)any())).thenReturn(null);
        var resp = libraryController.registerBook(new HttpEntity<String>(""));
        verify(service).process((HttpEntity<String>)any());
    }

    @Test
    public void borrowBook() {
        when(service.process((HttpEntity<String>)any())).thenReturn(null);
        var resp = libraryController.borrowBook(new HttpEntity<String>(""));
        verify(service).process((HttpEntity<String>)any());
    }

    @Test
    public void returnBorrowBook() {
        when(service.process((HttpEntity<String>)any())).thenReturn(null);
        var resp = libraryController.returnBorrowBook(new HttpEntity<String>(""));
        verify(service).process((HttpEntity<String>)any());
    }

    @Test
    public void listPage() {
        when(service.process((HttpEntity<String>)any())).thenReturn(null);
        var resp = libraryController.listPage(new HttpEntity<String>(""));
        verify(service).process((HttpEntity<String>)any());
    }

}
