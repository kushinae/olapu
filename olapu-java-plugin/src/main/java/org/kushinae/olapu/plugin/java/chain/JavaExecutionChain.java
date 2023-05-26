package org.kushinae.olapu.plugin.java.chain;

import org.kushinae.olapu.generate.mapping.HandlerMapping;
import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.chain.AbstractExecutionChain;
import org.kushinae.olapu.spi.factory.mapping.DefaultHandlerMappingFactory;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JavaExecutionChain extends AbstractExecutionChain {
    @Override
    public Language getLanguage() {
        return Language.JAVA;
    }

    @Override
    public HandlerMapping getHandlerMapping() {
        DefaultHandlerMappingFactory handlerMappingFactory = new DefaultHandlerMappingFactory();
        return handlerMappingFactory.getFactory(getLanguage());
    }
}
