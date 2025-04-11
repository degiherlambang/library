package co.id.middleware.libraryproject.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseRest implements Serializable {

    @JsonProperty("response_code")
    @Getter
    @Setter
    private String responseCode;

    @JsonProperty("response_desc")
    @Getter
    @Setter
    private String responseDesc;

    @JsonProperty("additional")
    @Getter
    @Setter
    private Map<String, Object> additional;

}
