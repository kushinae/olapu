package org.kushinae.olapu.api.authorization.security;

import org.kushinae.olapu.api.util.StringUtils;

import java.util.HashSet;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class Whitelist extends HashSet<String> {

    private String contentPath;

    @Override
    public boolean add(String s) {
        if (StringUtils.hasText(s) && StringUtils.startsWithIgnoreCase(s, contentPath)) {
            return super.add(s);
        }
        return super.add(contentPath + s);
    }

    public boolean addIgnorePrefix(String s) {
        return super.add(s);
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }
}
