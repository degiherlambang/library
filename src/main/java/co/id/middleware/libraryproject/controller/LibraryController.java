package co.id.middleware.libraryproject.controller;

import co.id.middleware.libraryproject.model.Book;
import co.id.middleware.libraryproject.service.ProcessLibraryCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class LibraryController {

    @Autowired
    @Qualifier("REGIS")
    private ProcessLibraryCommon regisService;

    @Autowired
    @Qualifier("BORROW")
    private ProcessLibraryCommon borrowService;

    @Autowired
    @Qualifier("RETURN-BORROW")
    private ProcessLibraryCommon returnService;

    @Autowired
    @Qualifier("LIST-BOOK-PAGE")
    private ProcessLibraryCommon listBookService;

    @PostMapping(path = "/api/v1/regis")
    public ResponseEntity<?> registerBook(HttpEntity<String> request) {
        return this.regisService.process(request);
    }

    @PostMapping(path = "/api/v1/borrow")
    public ResponseEntity<?> borrowBook(HttpEntity<String> request) {
        return this.borrowService.process(request);
    }

    @PostMapping(path = "/api/v1/borrow-return")
    public ResponseEntity<?> returnBorrowBook(HttpEntity<String> request) {
        return this.returnService.process(request);
    }

    @PostMapping(path = "/api/v1/list-page")
    public ResponseEntity<?> listPage(HttpEntity<String> request) {
        return this.listBookService.process(request);
    }

}
