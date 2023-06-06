package org.kushinae.olapu.api.authorization;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractAuthorization implements Authorization {

    private String uid;
    private String token;

    @Override
    public String getUid() {
        return uid;
    }

    @Override
    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }
}