package org.kushinae.olapu.repository.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum TemplateModel implements AttributeConverterSupport<TemplateModel.Convert> {

    CONTROLLER("ctrl"),
    SERVICE("svc"),
    REPOSITORY("repo"),
    DAO("dao"),
    ENTITY("entity"),
    ;

    @Override
    public Convert getConvert() {
        return new TemplateModel.Convert();
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<TemplateModel, String> {
        @Override
        public String convertToDatabaseColumn(TemplateModel attribute) {
            return attribute.code;
        }

        @Override
        public TemplateModel convertToEntityAttribute(String dbData) {
            return matchByCode(dbData);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TemplateModel matchByCode(String code) {
        for (TemplateModel value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported template model " + code);
    }

    @JsonValue
    private final String code;

    TemplateModel(String code) {
        this.code = code;
    }

}
