package org.kushinae.olapu.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum JobType implements EnumCode<String> {

    GENERATE("generate"),
    ;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static JobType matchByCode(String code) {
        for (JobType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported job type of the " + code + ".");
    }

    private final String code;

    JobType(String code) {
        this.code = code;
    }

    @Override
    @JsonValue
    public String getCode() {
        return this.code;
    }


}
