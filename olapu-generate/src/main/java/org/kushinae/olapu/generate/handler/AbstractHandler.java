package org.kushinae.olapu.generate.handler;

import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.ModelType;

import java.util.Map;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractHandler implements Handler {
    @Override
    public String getTemplate(BuildOption buildOption) {
        Map<ModelType, String> modelsTemplate = buildOption.getModelsTemplate();
        return modelsTemplate.get(getModelType());
    }
}
