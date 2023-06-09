package org.kushinae.olapu.api.http;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum StatusCode {

    OK(200, "SUCCESS"),

    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
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
