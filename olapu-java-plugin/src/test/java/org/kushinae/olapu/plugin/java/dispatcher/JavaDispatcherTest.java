package org.kushinae.olapu.plugin.java.dispatcher;

import org.junit.jupiter.api.Test;
import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.adapter.HandlerAdapter;
import org.kushinae.olapu.generate.chain.ExecutionChain;
import org.kushinae.olapu.generate.dispatcher.Dispatcher;
import org.kushinae.olapu.generate.mapping.HandlerMapping;
import org.kushinae.olapu.spi.factory.dispatcher.DefaultDispatcherFactory;

import static org.junit.jupiter.api.Assertions.*;

class JavaDispatcherTest {

    @Test
    void getExecutionChain() {

        BuildOption option = new BuildOption();
        option.setLanguage(Language.JAVA);
        DefaultDispatcherFactory dispatcherFactory = new DefaultDispatcherFactory();
        Dispatcher dispatcher = dispatcherFactory.getFactory(option.getLanguage());
        ExecutionChain executionChain = dispatcher.getExecutionChain(option);
        HandlerMapping handlerMapping = executionChain.getHandlerMapping();
        HandlerAdapter handlerAdapter = handlerMapping.getHandlerAdapter();
        Object handler = handlerAdapter.handler();
        System.out.println(handler);
    }
}