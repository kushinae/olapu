package org.kushinae.olapu.plugin.java.dispatcher;

import org.junit.jupiter.api.Test;
import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.adapter.HandlerAdapter;
import org.kushinae.olapu.generate.chain.ExecutionChain;
import org.kushinae.olapu.generate.dispatcher.Dispatcher;
import org.kushinae.olapu.generate.mapping.HandlerMapping;
import org.kushinae.olapu.spi.factory.DefaultGenerateChain;
import org.kushinae.olapu.spi.factory.dispatcher.DefaultDispatcherFactory;

import static org.junit.jupiter.api.Assertions.*;

class JavaDispatcherTest {

    @Test
    void getExecutionChain() {
        BuildOption option = new BuildOption();
        option.setLanguage(Language.JAVA);
        DefaultGenerateChain generateChain = new DefaultGenerateChain();
        generateChain.chain(option);
    }
}