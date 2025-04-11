package co.id.middleware.libraryproject.model.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class RequestRestListPageTest {

    private RequestRestListPage requestRestListPage = new RequestRestListPage();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testModel() {
        var obj = new RequestRestListPage();
        obj.setPage(1);
        obj.setPageSize(10);
        System.out.println(obj.getPage());
        System.out.println(obj.getPageSize());
    }

}
