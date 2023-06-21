package org.kushinae.olapu.api.enums;

import org.kushinae.olapu.repository.enums.CodeSupport;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum PubsubEventGroup implements CodeSupport<String> {
    JOB("job"),
    ;

    private final String code;

    PubsubEventGroup(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
