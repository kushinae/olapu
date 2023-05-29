package org.kushinae.olapu.generate;

import org.kushinae.olapu.generate.dispatcher.Dispatcher;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface GenerateChain {

    Record chain(BuildOption option);

    Dispatcher getDispatcher(BuildOption option);

}
