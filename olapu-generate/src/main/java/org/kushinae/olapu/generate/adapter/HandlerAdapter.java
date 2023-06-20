package org.kushinae.olapu.generate.adapter;

import org.kushinae.olapu.core.job.entities.generate.GenerateJob;
import org.kushinae.olapu.generate.LanguageCode;
import org.kushinae.olapu.generate.handler.Handler;

/**
 * 调用具体生成器(Generate of Java、Generate of Golang ....)
 *
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface HandlerAdapter extends LanguageCode {

    Handler getHandler(GenerateJob job);

}
