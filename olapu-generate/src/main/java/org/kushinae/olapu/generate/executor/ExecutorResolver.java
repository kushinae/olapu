package org.kushinae.olapu.generate.executor;

import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.LanguageCode;
import org.kushinae.olapu.generate.RecordResolver;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface ExecutorResolver extends LanguageCode {

    RecordResolver resolver(BuildOption option, String template);

    Executor getExecutor();

}
