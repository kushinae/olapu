package org.kushinae.olapu.repository.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum FileType implements AttributeConverterSupport<FileType.Convert>, CodeSupport<String> {

    FILE("file"),
    DIRECTORY("directory"),
    ;

    @Override
    public Convert getConvert() {
        return new FileType.Convert();
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<FileType, String> {

        @Override
        public String convertToDatabaseColumn(FileType attribute) {
            return attribute.getCode();
        }

        @Override
        public FileType convertToEntityAttribute(String dbData) {
            return matchByCode(dbData);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static FileType matchByCode(String code) {
        for (FileType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported file type " + code);
    }

    @JsonValue
    private final String code;

    FileType(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
