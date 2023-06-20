package org.kushinae.olapu.plugin.java.handler;

import org.kushinae.olapu.core.enums.Language;
import org.kushinae.olapu.core.enums.ModelType;
import org.kushinae.olapu.generate.executor.ExecutorResolver;
import org.kushinae.olapu.generate.handler.AbstractHandler;
import org.kushinae.olapu.spi.factory.executor.DefaultExecutorResolverFactory;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JavaControllerHandler extends AbstractHandler {

    @Override
    public Language getLanguage() {
        return Language.JAVA;
    }

    @Override
    public ModelType getModelType() {
        return ModelType.CTRL;
    }

    @Override
    public ExecutorResolver getExecutorResolver() {
        return new DefaultExecutorResolverFactory().getFactory(getLanguage());
    }
}
