package org.kushinae.olapu.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum EventMiddleware implements CodeSupport<String>, AttributeConverterSupport<EventMiddleware.Convert> {
    DISRUPTOR("disruptor"),
    ;

    private static final Convert convert = new Convert();
    @JsonValue
    private final String code;

    @Override
    public Convert getConvert() {
        return convert;
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<EventMiddleware, String> {

        @Override
        public String convertToDatabaseColumn(EventMiddleware attribute) {
            return attribute.getCode();
        }

        @Override
        public EventMiddleware convertToEntityAttribute(String dbData) {
            return matchByCode(dbData);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EventMiddleware matchByCode(String code) {
        for (EventMiddleware value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported event middleware of the " + code);
    }

    EventMiddleware(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
