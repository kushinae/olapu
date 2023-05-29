package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.pojo.api.generate.Generate;
import org.kushinae.olapu.api.service.GenerateService;
import org.kushinae.olapu.generate.Record;
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
public class GenerateController {

    @Resource
    GenerateService generateService;

    @PostMapping
    public Record generate(@RequestBody Generate generate) {
        return generateService.generate(generate);
    }

}
