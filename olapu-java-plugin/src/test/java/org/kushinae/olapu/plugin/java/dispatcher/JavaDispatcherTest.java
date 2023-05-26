package org.kushinae.olapu.plugin.java.dispatcher;

import org.junit.jupiter.api.Test;
import org.kushinae.olapu.core.utils.JacksonUtils;
import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.ModelType;
import org.kushinae.olapu.generate.Record;
import org.kushinae.olapu.spi.factory.DefaultGenerateChain;

import java.util.stream.Stream;

class JavaDispatcherTest {

    @Test
    void getExecutionChain() {
        BuildOption option = new BuildOption();
        option.setLanguage(Language.JAVA);
        option.setModel(Stream.of(ModelType.CTRL).toList());
        DefaultGenerateChain generateChain = new DefaultGenerateChain();
        Record record = generateChain.chain(option);
        System.out.println(JacksonUtils.toJsonString(record));
    }
}