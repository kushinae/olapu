package org.kushinae.olapu.api.generate;

import org.kushinae.olapu.api.enums.GenerateModelEnum;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface Generate extends Language {

    GenerateModel getGenerateModel(GenerateModelEnum model);

    void generate();

}
