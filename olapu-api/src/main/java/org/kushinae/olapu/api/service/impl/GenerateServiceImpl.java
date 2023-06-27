package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.service.DatasourceConfigureService;
import org.kushinae.olapu.api.service.DatasourceService;
import org.kushinae.olapu.api.service.GenerateService;
import org.kushinae.olapu.api.service.TemplateService;
import org.kushinae.olapu.core.enums.Language;
import org.kushinae.olapu.core.enums.ModelType;
import org.kushinae.olapu.core.job.entities.generate.GenerateColumn;
import org.kushinae.olapu.core.job.entities.generate.GenerateJob;
import org.kushinae.olapu.core.job.entities.generate.GenerateSettings;
import org.kushinae.olapu.generate.Record;
import org.kushinae.olapu.interfaces.pojo.api.generate.GeneratePayload;
import org.kushinae.olapu.interfaces.pojo.lang.DatasourceConfigureMapping;
import org.kushinae.olapu.repository.entities.Template;
import org.kushinae.olapu.spi.factory.DefaultGenerateChain;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class GenerateServiceImpl implements GenerateService {

    @Resource
    TemplateService templateService;

    @Resource
    DatasourceService datasourceService;

    @Resource
    DatasourceConfigureService datasourceConfigureService;


    @Override
    public Record generate(GeneratePayload generatePayload) {
        // 获取生成任务的脚本
        Template template = templateService.queryById(generatePayload.getTemplateId());
        DatasourceConfigureMapping mapping = datasourceConfigureService.load2Mapping(generatePayload.getDatasourceId());
        GenerateJob generateJob = new GenerateJob();
        generateJob.setColumns(Stream.of(new GenerateColumn()).toList());
        GenerateSettings settings = new GenerateSettings();
        settings.setLanguage(Language.matchByCode(generatePayload.getType().getCode()));
        settings.setModel(ModelType.matchByCode(generatePayload.getModel().getCode()));
        settings.setTemplate(template.getTemplate());
        generateJob.setSettings(settings);
        generateJob.setTable("olapu");
        DefaultGenerateChain chain = new DefaultGenerateChain();
        return chain.chain(generateJob);
    }
}
