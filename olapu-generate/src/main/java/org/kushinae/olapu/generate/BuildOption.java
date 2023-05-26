package org.kushinae.olapu.generate;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class BuildOption {

    private Language language;

    private List<ModelType> model;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<ModelType> getModel() {
        return model;
    }

    public void setModel(List<ModelType> model) {
        this.model = model;
    }
}
