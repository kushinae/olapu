package org.kushinae.olapu.generate;

/**
 * 调用具体生成器(Generate of Java、Generate of Golang ....)
 *
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface HandlerAdapter {

    /**
     * 执行具体的代码生成器执行方法
     *
     * @return 生成的结果模版
     */
    Object handler();

}
