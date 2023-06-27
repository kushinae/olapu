package org.kushinae.olapu.interfaces.controller.template;

import org.kushinae.olapu.interfaces.controller.IController;
import org.kushinae.olapu.interfaces.pojo.api.template.CreatePayload;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Validated
@RequestMapping("/template")
public interface ITemplateController extends IController {

    @PostMapping
    Long created(@RequestBody CreatePayload payload);

}
