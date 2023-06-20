package org.kushinae.olapu.spi.factory.executor;

import org.kushinae.olapu.core.enums.Language;
import org.kushinae.olapu.generate.executor.Executor;

import java.util.ServiceLoader;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractExecutorFactory implements ExecutorFactory {
    @Override
    public Executor getFactory(Language code) {
        ServiceLoader<Executor> executors = ServiceLoader.load(Executor.class);
        for (Executor executor : executors) {
            if (executor.getLanguage().equals(code)) {
                return executor;
            }
        }
        throw new IllegalArgumentException("Unsupported executor language");
    }
}
