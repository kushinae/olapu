package org.kushinae.olapu.api.enums;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum LanguageEnum implements CodeEnum<String> {

    JAVA("java"),
    ;

    public static LanguageEnum matchByCode(String code) {
        for (LanguageEnum value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new  IllegalArgumentException("Unsupported language of the " + code);
    }

    private final String code;

    LanguageEnum(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
