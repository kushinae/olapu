package org.kushinae.olapu.plugin.java.dispatcher;

import org.junit.jupiter.api.Test;
import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.spi.factory.DefaultGenerateChain;

class JavaDispatcherTest {

    @Test
    void getExecutionChain() {
        BuildOption option = new BuildOption();
        option.setLanguage(Language.JAVA);
        DefaultGenerateChain generateChain = new DefaultGenerateChain();
        generateChain.chain(option);
    }
}