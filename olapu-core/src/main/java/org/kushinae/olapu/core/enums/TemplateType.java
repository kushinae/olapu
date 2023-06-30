package org.kushinae.olapu.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum TemplateType implements AttributeConverterSupport<TemplateType.Convert>, CodeSupport<String> {

    JAVA("java"),
    ;

    @Override
    public Convert getConvert() {
        return new TemplateType.Convert();
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<TemplateType, String> {
        @Override
        public String convertToDatabaseColumn(TemplateType attribute) {
            return attribute.code;
        }

        @Override
        public TemplateType convertToEntityAttribute(String dbData) {
            return matchByCode(dbData);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TemplateType matchByCode(String code) {
        for (TemplateType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported template type " + code);
    }

    @JsonValue
    private final String code;

    TemplateType(String code) {
        this.code = code;
    }

}
