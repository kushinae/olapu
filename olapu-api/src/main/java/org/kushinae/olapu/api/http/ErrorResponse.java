package org.kushinae.olapu.api.http;

import lombok.Getter;

import java.util.Date;
import java.util.Locale;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Getter
public class ErrorResponse {

    private Integer status;

    private String error;

    private String path;

    private String message;

    private Date timestamp;

    private ErrorResponse() {
    }

    public static ErrorResponse conflict() {
        ErrorResponse response = new ErrorResponse();
        response.timestamp = new Date();
        response.status = StatusCode.CONFLICT.getCode();
        response.error = StatusCode.CONFLICT.getMessage();
        return response;
    }

    public static ErrorResponse badRequest() {
        ErrorResponse response = new ErrorResponse();
        response.timestamp = new Date();
        response.status = StatusCode.BAD_REQUEST.getCode();
        response.error = StatusCode.BAD_REQUEST.getMessage();
        return response;
    }

    public static ErrorResponse unauthorized() {
        ErrorResponse response = new ErrorResponse();
        response.timestamp = new Date();
        response.status = StatusCode.UNAUTHORIZED.getCode();
        response.error = StatusCode.UNAUTHORIZED.getMessage();
        return response;
    }

    public ErrorResponse path(String method, String path) {
        this.path = method.toUpperCase(Locale.ROOT) + " " + path;
        return this;
    }

    public ErrorResponse message(String message) {
        this.message = message;
        return this;
    }
}
