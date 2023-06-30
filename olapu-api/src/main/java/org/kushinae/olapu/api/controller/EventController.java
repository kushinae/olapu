package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.interfaces.controller.AbstractController;
import org.kushinae.olapu.interfaces.controller.event.IEventController;
import org.kushinae.olapu.interfaces.service.IEventService;
import org.kushinae.olapu.interfaces.service.IService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
public class EventController extends AbstractController implements IEventController {

    @Resource
    IEventService eventService;

    @Override
    public IService getService() {
        return eventService;
    }
}
