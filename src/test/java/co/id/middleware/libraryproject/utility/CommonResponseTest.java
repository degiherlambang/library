package co.id.middleware.libraryproject.utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class CommonResponseTest {

    private CommonResponse commonResponse = new CommonResponse();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCommonResponseListBooks() throws Exception {
        var resp = commonResponse.getCommonResponseListBooks("ANY",1, 2);
    }

    @Test
    public void getCommonResponseOk() throws Exception {
        var resp = commonResponse.getCommonResponseOk("ANY");
    }

    @Test
    public void getCommonResponseFailed() throws Exception {
        var resp = commonResponse.getCommonResponseFailed();
    }

    @Test
    public void getCommonResponseFailedAlreadyBorrowed() throws Exception {
        var resp = commonResponse.getCommonResponseFailedAlreadyBorrowed();
    }

}
