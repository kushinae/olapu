package org.kushinae.olapu.api.generate.java.strategy;

import org.kushinae.olapu.api.enums.GenerateModelEnum;
import org.kushinae.olapu.api.enums.LanguageEnum;
import org.kushinae.olapu.api.generate.GenerateModel;
import org.springframework.stereotype.Component;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Component
public class ControllerModelStrategy implements GenerateModel {
    @Override
    public GenerateModelEnum getModel() {
        return GenerateModelEnum.CONTROLLER;
    }

    @Override
    public LanguageEnum getLanguage() {
        return LanguageEnum.JAVA;
    }
}
