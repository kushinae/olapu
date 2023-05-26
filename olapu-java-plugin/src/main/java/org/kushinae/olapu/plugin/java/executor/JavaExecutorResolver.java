package org.kushinae.olapu.plugin.java.executor;

import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.executor.AbstractExecutorResolver;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JavaExecutorResolver extends AbstractExecutorResolver {
    @Override
    public Language getLanguage() {
        return Language.JAVA;
    }
}
