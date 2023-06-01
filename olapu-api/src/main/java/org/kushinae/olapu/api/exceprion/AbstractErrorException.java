package org.kushinae.olapu.api.exceprion;

import org.kushinae.olapu.api.http.ErrorMessage;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class AbstractErrorException extends RuntimeException {

    protected ErrorMessage error;

    public AbstractErrorException() {
    }

    public AbstractErrorException(ErrorMessage error) {
        this.error = error;
    }

    public AbstractErrorException(String message) {
        super(message);
    }

    public AbstractErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractErrorException(Throwable cause) {
        super(cause);
    }

    public AbstractErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ErrorMessage getError() {
        return error;
    }
}
