package org.kushinae.olapu.generate;

import org.kushinae.olapu.core.job.entities.generate.GenerateJob;
import org.kushinae.olapu.generate.dispatcher.Dispatcher;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface GenerateChain {

    Record chain(GenerateJob job);

    Dispatcher getDispatcher(GenerateJob job);

}
