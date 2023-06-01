package org.kushinae.olapu.api.exceprion;

import org.kushinae.olapu.api.http.ErrorMessage;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class AccessTokenException extends AbstractErrorException {

    public AccessTokenException(ErrorMessage error) {
        super(error);
    }

    public AccessTokenException(String message) {
        super(message);
    }
}
