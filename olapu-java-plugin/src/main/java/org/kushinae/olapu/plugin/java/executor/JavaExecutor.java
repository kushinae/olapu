package org.kushinae.olapu.plugin.java.executor;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.RecordResolver;
import org.kushinae.olapu.generate.executor.AbstractExecutor;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JavaExecutor extends AbstractExecutor {
    @Override
    public Language getLanguage() {
        return Language.JAVA;
    }

    @Override
    public String executor(RecordResolver recordResolver) {
        String template = recordResolver.getTemplate();
        StringWriter result = new StringWriter();
        try {
            Template name = new Template("whatname", template, new Configuration(new Version("2.3.23")));
            name.process(recordResolver.getDataModel(), result);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }
}
