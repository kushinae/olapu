package org.kushinae.olapu.generate.executor;

import org.kushinae.olapu.core.job.entities.generate.GenerateJob;
import org.kushinae.olapu.generate.LanguageCode;
import org.kushinae.olapu.generate.RecordResolver;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface ExecutorResolver extends LanguageCode {

    RecordResolver resolver(GenerateJob job, String template);

    Executor getExecutor();

}
