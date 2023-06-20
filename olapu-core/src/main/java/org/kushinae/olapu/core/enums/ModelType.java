package org.kushinae.olapu.core.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum ModelType implements EnumCode<String> {

    /* controller层 */
    CTRL("ctrl"),
    SVC("svc"),
    REPO("repo"),
    DAO("dao"),
    ENTITY("entity"),
    ;

    @JsonValue
    private final String code;

    public static ModelType matchByCode(String code) {
        ModelType[] values = values();
        for (ModelType value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported model type: " + code);
    }

    ModelType(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
