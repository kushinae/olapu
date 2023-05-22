package org.kushinae.olapu.api.generate.java;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.enums.LanguageEnum;
import org.kushinae.olapu.api.generate.Generate;
import org.kushinae.olapu.api.generate.GenerateFactory;
import org.springframework.stereotype.Component;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Component
public class JavaGenerateFactory implements GenerateFactory {

    @Resource
    JavaGenerate generate;

    @Override
    public Generate createGenerate() {
        return generate;
    }

    @Override
    public LanguageEnum getLanguage() {
        return LanguageEnum.JAVA;
    }
}
