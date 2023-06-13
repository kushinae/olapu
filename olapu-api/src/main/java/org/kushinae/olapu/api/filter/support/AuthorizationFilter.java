package org.kushinae.olapu.api.filter.support;

import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.kushinae.olapu.api.authorization.Authorization;
import org.kushinae.olapu.api.exceprion.UnAuthorizationException;
import org.kushinae.olapu.api.filter.AbstractAuthorizationFilter;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.api.service.AccountService;
import org.kushinae.olapu.api.util.AccessTokenUtils;
import org.kushinae.olapu.api.util.JWTToken;
import org.kushinae.olapu.api.util.StringUtils;

import java.io.IOException;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Log4j2
@WebFilter
public class AuthorizationFilter extends AbstractAuthorizationFilter {

    @Resource
    AccountService accountService;

    @Resource
    Authorization authorization;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (log.isInfoEnabled()) {
            log.info("[AuthorizationFilter] Servlet filter {} as started", filterConfig.getFilterName());
        }
    }

    @Override
    public void filter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (authorization.getWhitelist().contains(uri)) {
            if (log.isDebugEnabled()) {
                log.debug("[{}] request {} in whitelist direct release", this.getClass().getSimpleName(), uri);
            }
            chain.doFilter(request, response);
            return;
        }
        String header = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.nonText(header)) {
            throw new UnAuthorizationException(ErrorMessage.UN_AUTHENTICATION);
        }
        JWTToken purview = AccessTokenUtils.checkAccessPurview(request.getAuthType(), header, authorization.getAuthType());
        authorization.setToken(purview.getToken());
        authorization.setUid(purview.getUid());
        chain.doFilter(request, response);
    }
}
