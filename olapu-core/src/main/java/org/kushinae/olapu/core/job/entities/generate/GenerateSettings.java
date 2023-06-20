package org.kushinae.olapu.core.job.entities.generate;

import org.kushinae.olapu.core.enums.Language;
import org.kushinae.olapu.core.enums.ModelType;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class GenerateSettings {

    private Language language;

    private ModelType model;

    private String template;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public ModelType getModel() {
        return model;
    }

    public void setModel(ModelType model) {
        this.model = model;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
