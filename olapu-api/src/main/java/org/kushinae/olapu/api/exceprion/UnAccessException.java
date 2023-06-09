package org.kushinae.olapu.api.exceprion;

import org.kushinae.olapu.api.http.ErrorMessage;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class UnAccessException extends AbstractErrorException {

    public UnAccessException(ErrorMessage error) {
        super(error);
    }

    public UnAccessException(String message) {
        super(message);
    }
}
