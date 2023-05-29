package org.kushinae.olapu.generate;

import java.util.List;
import java.util.Map;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class BuildOption {

    private Language language;

    private Map<ModelType, String> modelsTemplate;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Map<ModelType, String> getModelsTemplate() {
        return modelsTemplate;
    }

    public void setModelsTemplate(Map<ModelType, String> modelsTemplate) {
        this.modelsTemplate = modelsTemplate;
    }
}
