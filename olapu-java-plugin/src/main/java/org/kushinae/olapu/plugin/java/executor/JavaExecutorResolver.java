package org.kushinae.olapu.plugin.java.executor;

import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.RecordResolver;
import org.kushinae.olapu.generate.executor.AbstractExecutorResolver;
import org.kushinae.olapu.generate.executor.Executor;
import org.kushinae.olapu.spi.factory.executor.DefaultExecutorFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JavaExecutorResolver extends AbstractExecutorResolver {
    @Override
    public Language getLanguage() {
        return Language.JAVA;
    }

    @Override
    public RecordResolver resolver(BuildOption option, String template) {
        Map<String, Object> dataModel = new HashMap<>();
        // todo 这里模版字符串替换也从客户端(引入该项目)服务拿
        dataModel.put("className", "HelloWorld");
        RecordResolver recordResolver = new RecordResolver();
        recordResolver.setDataModel(dataModel);
        recordResolver.setTemplate(template);
        return recordResolver;
    }

    @Override
    public Executor getExecutor() {
        return new DefaultExecutorFactory().getFactory(getLanguage());
    }
}
