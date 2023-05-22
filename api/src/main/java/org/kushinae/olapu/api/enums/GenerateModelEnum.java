package org.kushinae.olapu.api.enums;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum GenerateModelEnum implements CodeEnum<String> {
    CONTROLLER("ctl"),
    SERVICE("svc"),
    REPOSITORY("repo"),
    DAO("dao"),
    MODEL("model"),
    ;

    public static GenerateModelEnum matchByCode(String code) {
        for (GenerateModelEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported generate model of code " + code);
    }

    private final String code;

    GenerateModelEnum(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
