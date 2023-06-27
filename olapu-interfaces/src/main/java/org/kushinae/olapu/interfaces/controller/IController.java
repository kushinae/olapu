package org.kushinae.olapu.interfaces.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.interfaces.authorization.Authorization;
import org.kushinae.olapu.interfaces.service.IService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IController {

    @InitBinder
    default void registerBinder(WebDataBinder binder) {

    }

    Authorization getAuthorization();

    @Resource
    void setAuthorization(Authorization authorization);

    IService getService();

}
