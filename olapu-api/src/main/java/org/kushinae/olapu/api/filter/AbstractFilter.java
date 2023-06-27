package org.kushinae.olapu.api.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.kushinae.heimerdinger.core.utils.JacksonUtils;
import org.kushinae.olapu.api.http.ErrorResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Log4j2
public abstract class AbstractFilter implements OlapuFilter {

    @Override
    public void onError(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        ErrorResponse message = ErrorResponse.internalServerError().path(method, requestURI).message(e.getMessage());
        PrintWriter writer = response.getWriter();
        writer.write(JacksonUtils.toJsonString(message));
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest request && servletResponse instanceof HttpServletResponse response) {
            try {
                filter(request, response, chain);
            } catch (Exception e) {
                log.error("Handler filter exception {}", e.getMessage(), e);
                onError(request, response, e);
            }
        } else {
            if (log.isErrorEnabled()) {
                log.warn("[AbstractFilter] handler internal filter fail.");
            }
        }
    }
}
