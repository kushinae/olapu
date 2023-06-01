package org.kushinae.olapu.api.exceprion;

import org.kushinae.olapu.api.http.ErrorMessage;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class InternalServerException extends AbstractErrorException {

    public InternalServerException(ErrorMessage error) {
        super(error);
    }
}
