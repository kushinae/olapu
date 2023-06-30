package org.kushinae.olapu.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.kushinae.heimerdinger.core.enums.JobType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum EJobType implements CodeSupport<String>, AttributeConverterSupport<EJobType.Convert> {
    GENERATE(JobType.GENERATE.getCode()),
    ;

    @Override
    public Convert getConvert() {
        return new Convert();
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<EJobType, String> {
        @Override
        public String convertToDatabaseColumn(EJobType attribute) {
            return attribute.code;
        }

        @Override
        public EJobType convertToEntityAttribute(String dbData) {
            return matchByCode(dbData);
        }

    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EJobType matchByCode(String code) {
        for (EJobType value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported job type of the " + code);
    }

    @JsonValue
    private final String code;

    EJobType(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
