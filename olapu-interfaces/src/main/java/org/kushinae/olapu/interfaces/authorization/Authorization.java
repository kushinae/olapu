package org.kushinae.olapu.interfaces.authorization;

import org.kushinae.olapu.interfaces.enums.TokenType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface Authorization {

    String getUid();

    void setUid(String uid);

    String getToken();

    void setToken(String token);

    Whitelist getWhitelist();

    void setWhitelist(Whitelist whitelist);

    TokenType getAuthType();

}
