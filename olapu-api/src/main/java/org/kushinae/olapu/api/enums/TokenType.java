package org.kushinae.olapu.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum TokenType {

    BEARER("Bearer"),
    ;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TokenType matchBySerial(String serial) {
        for (TokenType value : values()) {
            if (value.serial.equals(serial)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported token type");
    }

    @JsonValue
    private final String serial;

    TokenType(String serial) {
        this.serial = serial;
    }

    public String getSerial() {
        return serial;
    }
}
