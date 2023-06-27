package org.kushinae.olapu.interfaces.authorization;

import org.kushinae.olapu.interfaces.enums.TokenType;

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
