package org.kushinae.olapu.interfaces.authorization;

import java.util.HashSet;

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

    public boolean addAny(String s) {
        if (s.startsWith(prePath)) {
            return super.add(s);
        } else {
            super.add(s);
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
