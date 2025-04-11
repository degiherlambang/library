package co.id.middleware.libraryproject.service;

import co.id.middleware.libraryproject.model.Book;
import co.id.middleware.libraryproject.model.dto.ResponseRest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProcessLibraryCommon {

    public ResponseEntity<?> process(HttpEntity<String> reqEntity);

}
