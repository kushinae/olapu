package org.kushinae.olapu.interfaces.controller.event;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.kushinae.olapu.interfaces.controller.IController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RequestMapping("/event")
@Tag(name = "事件管理控制器")
public interface IEventController extends IController {
}
