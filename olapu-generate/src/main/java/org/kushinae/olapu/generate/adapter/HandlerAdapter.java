package org.kushinae.olapu.generate.adapter;

import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.LanguageCode;
import org.kushinae.olapu.generate.handler.Handler;

import java.util.List;

/**
 * 调用具体生成器(Generate of Java、Generate of Golang ....)
 *
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface HandlerAdapter extends LanguageCode {

    List<Handler> getHandlers(BuildOption option);

}
