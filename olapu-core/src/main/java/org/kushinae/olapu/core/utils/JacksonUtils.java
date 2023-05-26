package org.kushinae.olapu.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JacksonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJsonString(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
