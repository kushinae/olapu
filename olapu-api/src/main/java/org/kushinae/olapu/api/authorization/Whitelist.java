package org.kushinae.olapu.api.authorization;

import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class Whitelist extends HashSet<String> {

    private String prePath;

    public boolean addOnPrefix(String s) {
        if (s.startsWith(prePath)) {
            return super.add(s);
        } else {
            return super.add(prePath + s);
        }
    }

    public String getPrePath() {
        return prePath;
    }

    public void setPrePath(String prePath) {
        this.prePath = prePath;
    }
}
