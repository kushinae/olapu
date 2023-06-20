package org.kushinae.olapu.spi.factory.executor;

import org.kushinae.olapu.core.enums.Language;
import org.kushinae.olapu.generate.executor.ExecutorResolver;

import java.util.ServiceLoader;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractExecutorResolverFactory implements ExecutorResolverFactory {
    @Override
    public ExecutorResolver getFactory(Language code) {
        ServiceLoader<ExecutorResolver> executorResolvers = ServiceLoader.load(ExecutorResolver.class);
        for (ExecutorResolver executorResolver : executorResolvers) {
            if (executorResolver.getLanguage().equals(code)) {
                return executorResolver;
            }
        }
        throw new IllegalArgumentException("Unsupported executor language");
    }
}
