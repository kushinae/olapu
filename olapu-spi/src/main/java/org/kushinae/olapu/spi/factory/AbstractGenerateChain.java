package org.kushinae.olapu.spi.factory;

import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.GenerateChain;
import org.kushinae.olapu.generate.adapter.HandlerAdapter;
import org.kushinae.olapu.generate.chain.ExecutionChain;
import org.kushinae.olapu.generate.dispatcher.Dispatcher;
import org.kushinae.olapu.generate.mapping.HandlerMapping;
import org.kushinae.olapu.spi.factory.dispatcher.DefaultDispatcherFactory;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractGenerateChain implements GenerateChain {

    @Override
    public void chain(BuildOption option) {
        DefaultDispatcherFactory dispatcherFactory = new DefaultDispatcherFactory();
        Dispatcher dispatcher = dispatcherFactory.getFactory(option.getLanguage());
        ExecutionChain executionChain = dispatcher.getExecutionChain(option);
        HandlerMapping handlerMapping = executionChain.getHandlerMapping();
        HandlerAdapter handlerAdapter = handlerMapping.getHandlerAdapter();
        Object handler = handlerAdapter.handler();
        System.out.println(handler);
    }
}
