package co.id.middleware.libraryproject.service.impl;

import co.id.middleware.libraryproject.business.BookBusiness;
import co.id.middleware.libraryproject.model.Book;
import co.id.middleware.libraryproject.model.dto.ResponseRest;
import co.id.middleware.libraryproject.service.ProcessLibraryCommon;
import co.id.middleware.libraryproject.utility.CommonResponse;
import co.id.middleware.libraryproject.utility.ObjectMapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
@Qualifier("REGIS")
public class RegisBookImpl implements ProcessLibraryCommon {

    @Autowired
    private BookBusiness business;

    @Autowired
    private ObjectMapperUtil mapper;

    @Override
    public ResponseEntity<?> process(HttpEntity<String> reqEntity) {
        try {
            Book data = mapper.deserialize(reqEntity.getBody(), Book.class);
            data.setCreatedDate(new Date());
            business.save(data);
            return new CommonResponse().getCommonResponseOk(data);
        } catch (Exception e) {
            log.info("error: {}", e.getMessage());
            return new CommonResponse().getCommonResponseFailed();
        }
    }

}
