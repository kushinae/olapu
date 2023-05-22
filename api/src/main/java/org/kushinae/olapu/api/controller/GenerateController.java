package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.enums.GenerateModelEnum;
import org.kushinae.olapu.api.enums.LanguageEnum;
import org.kushinae.olapu.api.generate.Generate;
import org.kushinae.olapu.api.generate.GenerateFactory;
import org.kushinae.olapu.api.param.generate.GenerateParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/generate")
public class GenerateController {

    @Resource
    private List<GenerateFactory> generateFactories;

    @PostMapping("/code")
    public String generateCode(@RequestParam GenerateParam param) {
        LanguageEnum languageEnum = LanguageEnum.matchByCode(param.getLanguage());
        for (GenerateFactory generateFactory : generateFactories) {
            if (generateFactory.getLanguage().equals(languageEnum)) {
                Generate factoryGenerate = generateFactory.createGenerate();
                factoryGenerate.generate();
            }
        }
        return param.toString();
    }

}
