package org.kushinae.olapu.generate.executor;

import org.kushinae.olapu.generate.LanguageCode;
import org.kushinae.olapu.generate.RecordResolver;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface Executor extends LanguageCode {

    String executor(RecordResolver recordResolver);

}
