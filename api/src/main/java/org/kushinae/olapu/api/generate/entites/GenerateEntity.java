package org.kushinae.olapu.api.generate.entites;

import org.kushinae.olapu.api.enums.GenerateModelEnum;
import org.kushinae.olapu.api.enums.LanguageEnum;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class GenerateEntity {

    private GenerateModelEnum generateModel;

    private LanguageEnum language;

    public GenerateModelEnum getGenerateModel() {
        return generateModel;
    }

    public void setGenerateModel(GenerateModelEnum generateModel) {
        this.generateModel = generateModel;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "GenerateEntity{" +
                "generateModel=" + generateModel +
                ", language=" + language +
                '}';
    }
}
