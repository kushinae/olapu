package org.kushinae.olapu.generate.handler;

import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.LanguageCode;
import org.kushinae.olapu.generate.ModelTypeCode;
import org.kushinae.olapu.generate.executor.ExecutorResolver;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface Handler extends LanguageCode, ModelTypeCode {

    String getTemplate(BuildOption buildOption);

    ExecutorResolver getExecutorResolver();

}
