package org.kushinae.olapu.api.generate.java;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.enums.GenerateModelEnum;
import org.kushinae.olapu.api.enums.LanguageEnum;
import org.kushinae.olapu.api.generate.Generate;
import org.kushinae.olapu.api.generate.GenerateModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Component
public class JavaGenerate implements Generate {

    @Resource
    List<GenerateModel> generateModels;

    @Override
    public LanguageEnum getLanguage() {
        return LanguageEnum.JAVA;
    }

    @Override
    public GenerateModel getGenerateModel(GenerateModelEnum model) {
        return null;
    }

    @Override
    public void generate() {

    }
}
