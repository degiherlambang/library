package co.id.middleware.libraryproject.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class RequestRestListPage {

    @JsonProperty("page")
    @Getter
    @Setter
    private int page;

    @JsonProperty("page_size")
    @Getter
    @Setter
    private int pageSize;

}
