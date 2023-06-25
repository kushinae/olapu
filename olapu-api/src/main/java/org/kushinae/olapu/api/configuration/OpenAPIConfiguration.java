package org.kushinae.olapu.api.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Olapu restful api document")
                        .description("Olapu restful api document")
                        .version("1.0.0")
                );
    }

}
