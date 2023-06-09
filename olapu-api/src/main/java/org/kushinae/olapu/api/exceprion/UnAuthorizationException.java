package org.kushinae.olapu.api.exceprion;

import org.kushinae.olapu.api.http.ErrorMessage;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class UnAuthorizationException extends AbstractErrorException {

    public UnAuthorizationException(ErrorMessage error) {
        super(error);
    }
}
