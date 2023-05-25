package org.kushinae.olapu.generate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.kushinae.olapu.core.enums.EnumCode;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum Language implements EnumCode<String> {

    JAVA("java"),
    ;

    @JsonValue
    private final String code;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Language matchByCode(String code) {
        for (Language value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported language of the " + code);
    }

    Language(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
