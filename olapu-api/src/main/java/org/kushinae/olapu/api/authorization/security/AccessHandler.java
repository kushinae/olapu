package org.kushinae.olapu.api.authorization.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.kushinae.olapu.api.http.ErrorResponse;
import org.kushinae.olapu.core.utils.JacksonUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Log4j2
public class AccessHandler implements AccessDeniedHandler, AuthenticationEntryPoint {

    /**
     * 拒绝访问
     * @param request that resulted in an <code>AccessDeniedException</code>
     * @param response so that the user agent can be advised of the failure
     * @param accessDeniedException that caused the invocation
     * @throws IOException in the event of an IOException
     * @throws ServletException in the event of a ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if (log.isErrorEnabled()) {
            log.error("Access denied handler", accessDeniedException);
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        ErrorResponse unauthorized = ErrorResponse.unauthorized();
        if (null != accessDeniedException) {
            unauthorized.message(accessDeniedException.getMessage());
        }
        unauthorized.path(request.getMethod(), request.getRequestURI());
        response.getWriter().println(unauthorized);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if (log.isErrorEnabled()) {
            log.error("Authentication entry point", authException);
        }
        ErrorResponse unauthorized = ErrorResponse.unauthorized();
        if (null != authException) {
            unauthorized.message(authException.getMessage());
        }
        unauthorized.path(request.getMethod(), request.getRequestURI());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter()
                .write(JacksonUtils.toJsonString(unauthorized));
        response.setStatus(401);
    }

}
