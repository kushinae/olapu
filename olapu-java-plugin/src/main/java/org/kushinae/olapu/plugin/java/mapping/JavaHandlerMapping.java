package org.kushinae.olapu.plugin.java.mapping;

import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.adapter.HandlerAdapter;
import org.kushinae.olapu.generate.mapping.AbstractHandlerMapping;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JavaHandlerMapping extends AbstractHandlerMapping {
    @Override
    public Language getLanguage() {
        return Language.JAVA;
    }

    @Override
    public HandlerAdapter getHandlerAdapter() {
        return null;
    }
}
