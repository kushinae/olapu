package org.kushinae.olapu.generate.chain;

import org.kushinae.olapu.generate.mapping.HandlerMapping;
import org.kushinae.olapu.generate.LanguageCode;

/**
 * 执行链
 *
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface ExecutionChain extends LanguageCode {

    HandlerMapping getHandlerMapping();

}
