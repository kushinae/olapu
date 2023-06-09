package org.kushinae.olapu.api.authorization;

import org.kushinae.olapu.api.enums.TokenType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class DefaultAuthorization extends AbstractAuthorization {

    public DefaultAuthorization() {
    }

    @Override
    public TokenType getAuthType() {
        return TokenType.BEARER;
    }
}
