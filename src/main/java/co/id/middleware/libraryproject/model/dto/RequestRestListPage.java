package co.id.middleware.libraryproject.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestRestListPage implements Serializable {

    @JsonProperty("page")
    @Getter
    @Setter
    private int page;

    @JsonProperty("page_size")
    @Getter
    @Setter
    private int pageSize;

}
