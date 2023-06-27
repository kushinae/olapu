package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.interfaces.controller.generate.IGenerateController;
import org.kushinae.olapu.interfaces.service.IGenerateService;
import org.kushinae.heimerdinger.core.generate.Record;
import org.kushinae.olapu.interfaces.controller.AbstractController;
import org.kushinae.olapu.interfaces.pojo.api.generate.GeneratePayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/generate")
public class GenerateController extends AbstractController implements IGenerateController {

    @Resource
    IGenerateService generateService;

    @PostMapping
    public Record generate(@RequestBody GeneratePayload generatePayload) {
        return getService().generate(generatePayload);
    }

    @Override
    public IGenerateService getService() {
        return generateService;
    }
}
