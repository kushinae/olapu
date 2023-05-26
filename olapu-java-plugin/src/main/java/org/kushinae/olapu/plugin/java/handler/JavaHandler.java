package org.kushinae.olapu.plugin.java.handler;

import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.handler.AbstractHandler;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JavaHandler extends AbstractHandler {
    @Override
    public Language getLanguage() {
        return Language.JAVA;
    }
}
