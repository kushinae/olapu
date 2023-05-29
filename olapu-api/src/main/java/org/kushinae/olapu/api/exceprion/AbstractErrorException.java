package org.kushinae.olapu.api.exceprion;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class AbstractErrorException extends RuntimeException {

    public AbstractErrorException() {
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
}
