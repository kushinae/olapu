package org.kushinae.olapu.repository.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.checkerframework.checker.units.qual.C;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum JobModel implements CodeSupport<String>, AttributeConverterSupport<JobModel.Convert> {

    SCRIPT("script"),
    GUI("gui"),
    ;

    @JsonValue
    private final String code;

    @Override
    public Convert getConvert() {
        return new Convert();
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<JobModel, String> {
        @Override
        public String convertToDatabaseColumn(JobModel attribute) {
            return attribute.code;
        }

        @Override
        public JobModel convertToEntityAttribute(String dbData) {
            return matchByCode(dbData);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static JobModel matchByCode(String code) {
        for (JobModel value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported job model of the " + code);
    }

    JobModel(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
