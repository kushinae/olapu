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
        super(error.getCode());
        this.error = error;
    }

    public AbstractErrorException(String message) {
        super(message);
    }
}
