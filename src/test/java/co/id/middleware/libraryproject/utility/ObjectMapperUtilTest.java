package co.id.middleware.libraryproject.utility;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

public class ObjectMapperUtilTest {

    private ObjectMapperUtil objectMapperUtil = new ObjectMapperUtil();

    @Mock
    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(objectMapperUtil, "mapper", mapper);
    }

    @Test
    public void testDeserialize() throws Exception {
        var resp = objectMapperUtil.deserialize("", String.class);
    }

    @Test
    public void testDeserializeIfException() throws Exception {
        when(mapper.readValue((JsonParser) any(), (Class<Object>) any())).thenThrow(JsonProcessingException.class);
        var resp = objectMapperUtil.deserialize("", Integer.class);
    }
}
