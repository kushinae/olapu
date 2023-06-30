package org.kushinae.olapu.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum TemplateSource implements AttributeConverterSupport<TemplateSource.Convert>, CodeSupport<String> {
    GENERATE("generate"),
    ;

    @Override
    public Convert getConvert() {
        return new TemplateSource.Convert();
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<TemplateSource, String> {
        @Override
        public String convertToDatabaseColumn(TemplateSource attribute) {
            return attribute.code;
        }

        @Override
        public TemplateSource convertToEntityAttribute(String dbData) {
            return matchByCode(dbData);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TemplateSource matchByCode(String code) {
        for (TemplateSource value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported template source " + code);
    }

    @JsonValue
    private final String code;

    TemplateSource(String code) {
        this.code = code;
    }

}
