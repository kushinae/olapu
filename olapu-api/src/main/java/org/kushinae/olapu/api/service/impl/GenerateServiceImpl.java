package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.pojo.api.generate.GeneratePayload;
import org.kushinae.olapu.api.service.GenerateService;
import org.kushinae.olapu.api.service.TemplateService;
import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.ModelType;
import org.kushinae.olapu.generate.Record;
import org.kushinae.olapu.repository.entities.Template;
import org.kushinae.olapu.repository.repository.impl.TemplateRepository;
import org.kushinae.olapu.spi.factory.DefaultGenerateChain;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class GenerateServiceImpl implements GenerateService {

    @Resource
    TemplateService templateService;

    @Override
    public Record generate(GeneratePayload generatePayload) {
        BuildOption option = new BuildOption();
        TemplateRepository repository = templateService.getRepository();
        Template template = repository.searchBySourceAndTypeAndModel(generatePayload.getSource(), generatePayload.getType(), generatePayload.getModel());
        Map<ModelType, String> modelsTemplate = new HashMap<>();
        ModelType modelType = ModelType.matchByCode(template.getModel().getConvert().convertToDatabaseColumn(template.getModel()));
        modelsTemplate.put(modelType, template.getTemplate());
        option.setLanguage(Language.matchByCode(template.getType().getConvert().convertToDatabaseColumn(template.getType())));
        option.setModelsTemplate(modelsTemplate);
        DefaultGenerateChain chain = new DefaultGenerateChain();
        return chain.chain(option);
    }
}
