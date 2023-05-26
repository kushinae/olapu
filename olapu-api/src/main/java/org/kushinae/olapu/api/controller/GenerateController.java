package org.kushinae.olapu.api.controller;

import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.Record;
import org.kushinae.olapu.spi.factory.DefaultGenerateChain;
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

    @PostMapping
    public Record generate(@RequestBody BuildOption option) {
        DefaultGenerateChain chain = new DefaultGenerateChain();
        return chain.chain(option);
    }

}
