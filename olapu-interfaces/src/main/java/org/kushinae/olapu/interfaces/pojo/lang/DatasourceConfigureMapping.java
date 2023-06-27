package org.kushinae.olapu.interfaces.pojo.lang;

import org.kushinae.olapu.repository.entities.DatasourceConfigure;

import java.util.HashMap;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class DatasourceConfigureMapping extends HashMap<String, String> {

    protected static final String HOST_FIELD = "host";
    protected static final String PASSWORD_FIELD = "password";
    protected static final String PORT_FIELD = "port";
    protected static final String USERNAME_FIELD = "username";
    protected static final String DATABASE_FIELD = "database";

    /**
     * 获取数据源配置项中的 host 配置值 {@link DatasourceConfigure#getValue()}
     *
     * @return 返回host的配置值, 不带有任何协议及端口号的IP地址,如 <code>127.0.0.1</code>
     */
    public String getHost() {
        return get(HOST_FIELD);
    }

    /**
     * 获取数据源配置项中的 password 配置值 {@link DatasourceConfigure#getValue()}
     *
     * @return 返回密码配置值
     */
    public String getPassword() {
        return get(PASSWORD_FIELD);
    }

    /**
     * 获取数据源配置项中的 port 配置值 {@link DatasourceConfigure#getValue()}
     *
     * @return 返回端口配置值
     */
    public int getPort() {
        return Integer.parseInt(get(PORT_FIELD));
    }

    /**
     * 获取数据源配置项中的 username 配置值 {@link DatasourceConfigure#getValue()}
     *
     * @return 返回用户名配置值
     */
    public String getUsername() {
        return get(USERNAME_FIELD);
    }

    /**
     * 获取数据源配置项中的 database 配置值 {@link DatasourceConfigure#getValue()}
     *
     * @return 返回数据库配置值
     */
    public String getDatabase() {
        return get(DATABASE_FIELD);
    }

}
