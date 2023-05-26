package org.kushinae.olapu.generate.mapping;

import org.kushinae.olapu.generate.LanguageCode;
import org.kushinae.olapu.generate.adapter.HandlerAdapter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface HandlerMapping extends LanguageCode {

    HandlerAdapter getHandlerAdapter();

}
