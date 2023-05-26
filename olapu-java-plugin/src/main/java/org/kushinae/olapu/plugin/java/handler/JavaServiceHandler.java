package org.kushinae.olapu.plugin.java.handler;

import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.ModelType;
import org.kushinae.olapu.generate.executor.ExecutorResolver;
import org.kushinae.olapu.generate.handler.AbstractHandler;
import org.kushinae.olapu.spi.factory.executor.DefaultExecutorResolverFactory;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JavaServiceHandler extends AbstractHandler {

    @Override
    public Language getLanguage() {
        return Language.JAVA;
    }

    @Override
    public ModelType getModelType() {
        return ModelType.SVC;
    }

    @Override
    public String getTemplate(BuildOption buildOption) {
        return """
              <html>
               <head>
                 <title>欢迎!这是Service</title>
               </head>
               <body>
                 <h1>欢迎来到王者荣耀!</h1>
                 <p>这是 <b>${username}</b> 的
                 <a href="https://bnyte.github.io">博客</a>!
               </body>
               </html>
                """;
    }

    @Override
    public ExecutorResolver getExecutorResolver() {
        return new DefaultExecutorResolverFactory().getFactory(getLanguage());
    }
}
