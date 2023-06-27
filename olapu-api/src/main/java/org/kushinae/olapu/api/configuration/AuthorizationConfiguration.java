package org.kushinae.olapu.api.configuration;

import jakarta.annotation.Resource;
import org.kushinae.olapu.interfaces.authorization.Authorization;
import org.kushinae.olapu.interfaces.authorization.DefaultAuthorization;
import org.kushinae.olapu.interfaces.authorization.Whitelist;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Configuration
public class AuthorizationConfiguration {

    @Resource
    ServerProperties serverProperties;

    @Bean
    Authorization authorization() {
        DefaultAuthorization authorization = new DefaultAuthorization();
        authorization.setWhitelist(whitelist());
        return authorization;
    }

    @Bean
    Whitelist whitelist() {
        Whitelist whitelist = new Whitelist();
        whitelist.setPrePath(serverProperties.getServlet().getContextPath());
        whitelist.addOnPrefix("/login");
        whitelist.addOnPrefix("/doc.html");
        whitelist.addOnPrefix("/v3/api-docs");
        whitelist.addOnPrefix("/v3/api-docs/*");
        whitelist.addOnPrefix("/swagger-ui/*");
        return whitelist;
    }


}
