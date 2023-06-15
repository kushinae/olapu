package org.kushinae.olapu.api.http;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum ErrorMessage {

    /**
     * system error
     */
    UNKNOWN_EXCEPTION("system.error.unknown", "Internal service exception"),


    USERNAME_ALREADY_EXISTS("account.username.exists", "Username already exists"),
    AUTHENTICATION_FAILED("account.authentication.failed", "Account authentication failed"),
    UN_AUTHENTICATION("account.authentication.un_authentication", "Un authentication"),
    AUTHENTICATION_TOKEN_EXPIRED("account.authentication.expired", "Access token has expired"),
    WRONG_USERNAME_OR_PASSWORD("account.login.username_or_password.wrong", "Wrong user name or password"),

    RESOURCE_DOES_NOT_EXIST("resource.does_not_exist", "Resource does not exist"),
    RESOURCE_ALREADY_EXISTS("resource.exists", "Resource already exists"),
    UNSUPPORTED_RESOURCE_TYPE("resource.unsupported.type", "Unsupported resource type"),


    TEMPLATE_DATA_ALREADY_EXISTS("template.exists", "Template already exists"),
    TEMPLATE_NAME_ALREADY_EXISTS("template.name.exists", "Template name already exists"),

    DATASOURCE_ALREADY_EXISTS("datasource.exists", "Datasource already exists"),
    UNSUPPORTED_DATASOURCE_TYPE("datasource.unsupported", "Unsupported datasource type"),
    DATASOURCE_DOES_NOT_EXIST("datasource.does_not_exist", "Datasource does not exist"),
    DUPLICATE_DATA_SOURCE_CONFIGURATION_ITEMS("datasource.configure.duplicate.item", "Duplicate data source configuration items"),
    DATABASE_CANNOT_BE_EMPTY("database.database.can_not_be_empty", "Database cannot be empty"),
    ;

    /**
     * 通过错误code匹配默认异常消息]
     *
     * @param code 异常code
     * @return 如果没有通过异常code匹配到消息的话则会直接返回code作为消息返回
     */
    public static String matchDefaultMessageByCode(String code) {
        ErrorMessage[] values = values();
        for (ErrorMessage value : values) {
            if (value.getCode().equals(code)) {
                return value.getMessage();
            }
        }
        return code;
    }

    private final String code;

    /**
     * 默认回显错误信息展示
     */
    private final String message;

    ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
