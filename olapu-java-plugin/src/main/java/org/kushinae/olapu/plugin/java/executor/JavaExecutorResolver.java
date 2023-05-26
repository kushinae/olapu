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
        dataModel.put("username", "kaisa.liu");
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
