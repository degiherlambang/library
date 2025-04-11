package co.id.middleware.libraryproject.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperUtil {

    @Autowired
    private ObjectMapper mapper;

    public <T> T deserialize(String json, Class<T> clazz) throws Exception {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException var4) {
            throw new Exception(var4);
        }
    }

    public String serialize(Object obj) throws Exception {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException var3) {
            throw new Exception(var3);
        }
    }

}
