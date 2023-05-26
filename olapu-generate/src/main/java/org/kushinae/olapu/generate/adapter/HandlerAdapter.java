package org.kushinae.olapu.generate.adapter;

import org.kushinae.olapu.generate.LanguageCode;

/**
 * 调用具体生成器(Generate of Java、Generate of Golang ....)
 *
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface HandlerAdapter extends LanguageCode {

    /**
     * 执行具体的代码生成器执行方法
     *
     * @return 生成的结果模版
     */
    Object handler();

}
