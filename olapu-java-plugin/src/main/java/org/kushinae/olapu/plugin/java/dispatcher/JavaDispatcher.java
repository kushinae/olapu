package org.kushinae.olapu.plugin.java.dispatcher;

import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.chain.ExecutionChain;
import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.dispatcher.AbstractDispatcherGenerate;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JavaDispatcher extends AbstractDispatcherGenerate {



    @Override
    public Language getLanguage() {
        return Language.JAVA;
    }

    @Override
    public ExecutionChain getExecutionChain(BuildOption option) {
        return null;
    }
}
