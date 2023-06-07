package org.kushinae.olapu.api.config;

import jakarta.annotation.Resource;
import jakarta.servlet.Filter;
import org.kushinae.olapu.api.authorization.security.AccessHandler;
import org.kushinae.olapu.api.authorization.security.JWTProvider;
import org.kushinae.olapu.api.authorization.security.JwtAuthenticationTokenFilter;
import org.kushinae.olapu.api.authorization.security.Whitelist;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Resource(name = "accountServiceImpl")
    private UserDetailsService userDetailsService;

    @Resource
    ServerProperties serverProperties;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //由于使用的是JWT，这里不需要csrf防护
        return httpSecurity
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(register -> {
                    for (String uri : whitelistURI()) {
                        register.requestMatchers(uri).permitAll();
                    }
                    register.anyRequest().authenticated();
                })
                .sessionManagement(e -> e.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
                .userDetailsService(userDetailsService)
                .exceptionHandling(e -> e
                        .accessDeniedHandler(accessDeniedHandler())
                        .authenticationEntryPoint(authenticationEntryPoint()))
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        JWTProvider provider = new JWTProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public Filter jwtAuthFilter() {
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setUserDetailsService(userDetailsService);
        filter.setWhitelist(whitelistURI());
        return filter;
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new AccessHandler();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AccessHandler();
    }

    @Bean
    public Whitelist whitelistURI() {
        Whitelist whitelist = new Whitelist();
        whitelist.setContentPath(serverProperties.getServlet().getContextPath());
        whitelist.add("/login");
        whitelist.add("/register");
        whitelist.addIgnorePrefix("/register");
        whitelist.addIgnorePrefix("/error/**");
        return whitelist;
    }

}
