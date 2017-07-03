package com.mycompany.conv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mycompany.bean.CommonBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.ParameterizedType;

/**
 * Created by starfucker on 03/07/2017.
 * This class provide client essences handling
 */
public class BeanService {
    private static final Logger LOG = LoggerFactory.getLogger(BeanService.class);
    private static final int BUFFER_SIZE = 4096;
    private static BeanService INSTANCE;

    private ObjectMapper mapper;

    public static BeanService getInstance() {
        if (INSTANCE == null) {
            synchronized (BeanService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BeanService();
                }
            }
        }

        return INSTANCE;
    }

    private BeanService() {
        mapper = setupMapper();
        LOG.debug("Json mapper configured");
    }

    private ObjectMapper setupMapper() {
        final JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);

        return new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .setSerializationInclusion(JsonInclude.Include.NON_EMPTY)

            .disable(
                MapperFeature.AUTO_DETECT_GETTERS,
                MapperFeature.AUTO_DETECT_IS_GETTERS,
                MapperFeature.AUTO_DETECT_CREATORS,
                MapperFeature.AUTO_DETECT_SETTERS
            )

            .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
//                    .configure(MapperFeature.AUTO_DETECT_GETTERS, true)
//                    .configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true)
//                    .configure(MapperFeature.AUTO_DETECT_CREATORS, false)
//                    .configure(MapperFeature.AUTO_DETECT_SETTERS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true)
            .configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true)
//                    .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
//                    .setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.PUBLIC_ONLY)
//                    .setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE)
//                    .setVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.NONE)
            ;
    }

    @SuppressWarnings("WeakerAccess")
    public ObjectMapper getMapper() {
        return mapper;
    }

    /**
     * Convert simple tiny object
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public String toJson(final CommonBean<?> sendBean) throws JsonProcessingException {
        final String result = mapper.writeValueAsString(sendBean);
        return result;
    }

    /**
     * Complex objects must be passed via stream output
     * We avoid large object passing because of OutOfMemoryError
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public void toJson(final CommonBean<?> sendBean, final OutputStream outputStream) throws IOException {
        try(
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, BUFFER_SIZE)
        ) {
            mapper.writeValue(bufferedOutputStream, sendBean);
        }
    }

    @SuppressWarnings("UnnecessaryLocalVariable,unchecked") // TODO: implements it later
    public <T extends CommonBean<?>> T fromJson(final String beanAsString) throws IOException {
        final Class<T> persistentClass = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass())
            .getActualTypeArguments()[0];
        final T result = getMapper().readValue(beanAsString, persistentClass);
        return result;
    }
}
