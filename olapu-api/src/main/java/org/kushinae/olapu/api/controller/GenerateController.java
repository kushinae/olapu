package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.service.GenerateService;
import org.kushinae.olapu.generate.Record;
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
public class GenerateController extends AbstractController {

    @Resource
    GenerateService generateService;

    @PostMapping
    public Record generate(@RequestBody GeneratePayload generatePayload) {
        return generateService.generate(generatePayload);
    }

}
