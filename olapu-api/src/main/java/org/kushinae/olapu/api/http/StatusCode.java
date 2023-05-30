package org.kushinae.olapu.api.http;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum StatusCode {

    OK(200, "SUCCESS"),

    CONFLICT(409, "Repeat Data Conflict"),
    ;

    private final String message;

    private final Integer code;

    StatusCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
