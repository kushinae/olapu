package org.kushinae.olapu.repository.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum PubsubEventGroup implements CodeSupport<String>, AttributeConverterSupport<PubsubEventGroup.Convert> {
    JOB("job"),
    ;

    private final String code;

    @Override
    public Convert getConvert() {
        return new Convert();
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<PubsubEventGroup, String> {
        @Override
        public String convertToDatabaseColumn(PubsubEventGroup attribute) {
            return attribute.code;
        }

        @Override
        public PubsubEventGroup convertToEntityAttribute(String dbData) {
            return matchByCode(dbData);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PubsubEventGroup matchByCode(String code) {
        for (PubsubEventGroup value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported job model of the " + code);
    }

    PubsubEventGroup(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
