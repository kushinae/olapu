package org.kushinae.olapu.repository.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum PubsubEvent implements CodeSupport<String>, AttributeConverterSupport<PubsubEvent.Convert> {

    BUILD("build"),
    ;

    @JsonValue
    private final String code;

    @Override
    public Convert getConvert() {
        return new Convert();
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<PubsubEvent, String> {
        @Override
        public String convertToDatabaseColumn(PubsubEvent attribute) {
            return attribute.code;
        }

        @Override
        public PubsubEvent convertToEntityAttribute(String dbData) {
            return matchByCode(dbData);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PubsubEvent matchByCode(String code) {
        for (PubsubEvent value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported event of the " + code);
    }

    PubsubEvent(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
