package org.kushinae.olapu.spi.factory.chain;

import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.chain.ExecutionChain;

import java.util.ServiceLoader;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractExecutionChainFactory implements ExecutionChainFactory {

    @Override
    public ExecutionChain getFactory(Language code) {
        ServiceLoader<ExecutionChain> executionChains = ServiceLoader.load(ExecutionChain.class);
        for (ExecutionChain executionChain : executionChains) {
            if (executionChain.getLanguage().equals(code)) {
                return executionChain;
            }
        }
        throw new IllegalArgumentException("Unsupported execution chain language");
    }
}
