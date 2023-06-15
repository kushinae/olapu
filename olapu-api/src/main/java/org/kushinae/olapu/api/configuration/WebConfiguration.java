package org.kushinae.olapu.api.configuration;

import org.kushinae.olapu.repository.enums.DatasourceType;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Configuration
public class WebConfiguration {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(DatasourceType.class, new DatasourceType.Convert());
    }

}
