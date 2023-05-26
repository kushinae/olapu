package org.kushinae.olapu.plugin.java.adapter;

import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.adapter.AbstractHandlerAdapter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JavaHandlerAdapter extends AbstractHandlerAdapter {
    @Override
    public Language getLanguage() {
        return Language.JAVA;
    }

    @Override
    public Object handler() {
        return """
               public class HelloWorld {
                   public static void main(String[] args) {
                       System.out.println("这是Java生成的代码！！！");
                   }
               }
               """;
    }
}
