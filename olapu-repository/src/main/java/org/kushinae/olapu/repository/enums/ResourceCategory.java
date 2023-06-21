package org.kushinae.olapu.repository.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.beans.PropertyEditorSupport;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum ResourceCategory implements CodeSupport<String>, AttributeConverterSupport<ResourceCategory.Convert> {

    JOB("job"),
    RESOURCE("resource"),
    ;

    @JsonValue
    private final String code;

    @Override
    public Convert getConvert() {
        return new Convert();
    }

    @Converter(autoApply = true)
    public static class Convert extends PropertyEditorSupport implements AttributeConverter<ResourceCategory, String> {

        @Override
        public String convertToDatabaseColumn(ResourceCategory attribute) {
            return attribute.getCode();
        }

        @Override
        public ResourceCategory convertToEntityAttribute(String dbData) {
            return matchByCode(dbData);
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(matchByCode(text));
        }

    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ResourceCategory matchByCode(String code) {
        for (ResourceCategory value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported resource category " + code);
    }

    ResourceCategory(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
