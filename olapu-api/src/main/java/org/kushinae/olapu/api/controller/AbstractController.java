package org.kushinae.olapu.api.controller;

import org.kushinae.olapu.repository.enums.DatasourceType;
import org.kushinae.olapu.repository.enums.ResourceCategory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractController implements IController {

    @Override
    public void registerBinder(WebDataBinder binder) {
        binder.registerCustomEditor(DatasourceType.class, new DatasourceType.Convert());
        binder.registerCustomEditor(ResourceCategory.class, new ResourceCategory.Convert());
    }

}
