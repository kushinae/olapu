package org.kushinae.olapu.api.authorization;

import org.kushinae.olapu.api.enums.TokenType;

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
