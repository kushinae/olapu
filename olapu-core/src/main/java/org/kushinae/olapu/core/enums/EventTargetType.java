package org.kushinae.olapu.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum EventTargetType implements CodeSupport<String>, AttributeConverterSupport<EventTargetType.Convert> {
    JOB("job"),
    ;

    private static final Convert convert = new Convert();
    @JsonValue
    private final String code;

    @Override
    public Convert getConvert() {
        return convert;
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<EventTargetType, String> {

        @Override
        public String convertToDatabaseColumn(EventTargetType attribute) {
            return attribute.getCode();
        }

        @Override
        public EventTargetType convertToEntityAttribute(String dbData) {
            return matchByCode(dbData);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EventTargetType matchByCode(String code) {
        for (EventTargetType value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported event target type of the " + code);
    }

    EventTargetType(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
