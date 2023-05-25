package org.kushinae.olapu.generate.dispatcher;

import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.chain.ExecutionChain;
import org.kushinae.olapu.generate.LanguageCode;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface Dispatcher extends LanguageCode {

    /**
     * 获取执行链对象
     *
     * @return 返回一个执行链对象
     */
    ExecutionChain getExecutionChain(BuildOption option);



}
