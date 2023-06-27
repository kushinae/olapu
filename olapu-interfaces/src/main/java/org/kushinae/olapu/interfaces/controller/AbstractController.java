package org.kushinae.olapu.interfaces.controller;

import org.kushinae.olapu.interfaces.authorization.Authorization;
import org.kushinae.olapu.interfaces.service.IService;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.kushinae.olapu.repository.enums.ResourceCategory;
import org.springframework.web.bind.WebDataBinder;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractController implements IController {

    protected Authorization authorization;

    protected IService service;

    @Override
    public void registerBinder(WebDataBinder binder) {
        binder.registerCustomEditor(DatasourceType.class, new DatasourceType.Convert());
        binder.registerCustomEditor(ResourceCategory.class, new ResourceCategory.Convert());
    }

    @Override
    public Authorization getAuthorization() {
        return authorization;
    }

    @Override
    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

}
