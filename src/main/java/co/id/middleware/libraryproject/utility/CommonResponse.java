package co.id.middleware.libraryproject.utility;


import co.id.middleware.libraryproject.model.dto.ResponseRest;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class CommonResponse {

    public ResponseEntity<ResponseRest> getCommonResponseListBooks(Object data, int page, int pageSize) throws Exception {
        return ResponseEntity.ok(this.getResponseRestListBooks("200", "success", data, page, pageSize));
    }

    public ResponseEntity<ResponseRest> getCommonResponseOk(Object data) {
        return ResponseEntity.ok(this.getResponseRest("200", "success", data));
    }

    public ResponseEntity<ResponseRest> getCommonResponseFailed() {
        return ResponseEntity.ok(this.getResponseRest("500", "failed", null));
    }

    public ResponseEntity<ResponseRest> getCommonResponseFailedAlreadyBorrowed() {
        return ResponseEntity.ok(this.getResponseRest("500", "failed Already Borrowed, Not Yet Returned", null));
    }

    private ResponseRest getResponseRestListBooks(String code, String desc, Object data, int page, int pageSize) {
        ResponseRest response = new ResponseRest();
        response.setResponseCode(code);
        response.setResponseDesc(desc);
        Map<String, Object> map = new HashMap<>();
        map.put("data", data);
        map.put("page", page);
        map.put("pageSize", pageSize);
        response.setAdditional(map);
        return response;
    }

    private ResponseRest getResponseRest(String code, String desc, Object data) {
        ResponseRest response = new ResponseRest();
        response.setResponseCode(code);
        response.setResponseDesc(desc);
        Map<String, Object> map = new HashMap<>();
        map.put("data", data);
        response.setAdditional(map);
        return response;
    }

}
