package org.kushinae.olapu.interfaces.controller.generate;

import org.kushinae.olapu.interfaces.controller.IController;
import org.kushinae.olapu.interfaces.service.IGenerateService;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IGenerateController extends IController {

    @Override
    IGenerateService getService();
}
