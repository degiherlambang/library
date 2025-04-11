package co.id.middleware.libraryproject.service.impl;

import co.id.middleware.libraryproject.business.BookBusiness;
import co.id.middleware.libraryproject.model.dto.RequestRestListPage;
import co.id.middleware.libraryproject.model.dto.ResponseRest;
import co.id.middleware.libraryproject.service.ProcessLibraryCommon;
import co.id.middleware.libraryproject.utility.CommonResponse;
import co.id.middleware.libraryproject.utility.ObjectMapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Qualifier("LIST-BOOK-PAGE")
public class ListBookWithPageImpl implements ProcessLibraryCommon {

    @Autowired
    private BookBusiness business;

    @Autowired
    private ObjectMapperUtil mapper;

    @Override
    public ResponseEntity<?> process(HttpEntity<String> reqEntity) {
        int page = 0;
        int pageSize = 0;
        try {
            RequestRestListPage data = mapper.deserialize(reqEntity.getBody(), RequestRestListPage.class);
            if (data!=null) {
                page = (data.getPageSize()*data.getPage())-data.getPageSize();
                pageSize = data.getPageSize();
            }
            return new CommonResponse().getCommonResponseOk((business.findBookWithPage(String.valueOf(page), String.valueOf(pageSize))));
        } catch (Exception e) {
            log.info("error: {}", e.getMessage());
            return new CommonResponse().getCommonResponseFailed();
        }
    }

}
