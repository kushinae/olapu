package org.kushinae.olapu.interfaces.controller;

import org.kushinae.olapu.interfaces.authorization.Authorization;
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

    void setAuthorization(Authorization authorization);

}
