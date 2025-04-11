package co.id.middleware.libraryproject.service.impl;

import co.id.middleware.libraryproject.business.BorrowDataBusiness;
import co.id.middleware.libraryproject.model.BorrowData;
import co.id.middleware.libraryproject.service.ProcessLibraryCommon;
import co.id.middleware.libraryproject.utility.CommonResponse;
import co.id.middleware.libraryproject.utility.ObjectMapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@Qualifier("RETURN-BORROW")
public class BorrowBookReturnImpl implements ProcessLibraryCommon {

    @Autowired
    private BorrowDataBusiness business;

    @Autowired
    private ObjectMapperUtil mapper;

    @Override
    public ResponseEntity<?> process(HttpEntity<String> reqEntity) {
        try {
            BorrowData reqData = mapper.deserialize(reqEntity.getBody(), BorrowData.class);
            BorrowData data = business.findBorrowDataByBookId(reqData.getBookId());
            data.setUpdatedDate(new Date());
            data.setLoanStatus("RETURNED");
            data.setLoanReturnDate(new Date());
            business.save(data);
            return new CommonResponse().getCommonResponseOk(data);
        } catch (Exception e) {
            log.info("error: {}", e.getMessage());
            return new CommonResponse().getCommonResponseFailed();
        }
    }

}
