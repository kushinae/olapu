package org.kushinae.olapu.interfaces.enums;

import org.kushinae.olapu.repository.enums.CodeSupport;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum PubsubEvent implements CodeSupport<String> {

    BUILD("build"),
    ;

    private final String code;

    PubsubEvent(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
