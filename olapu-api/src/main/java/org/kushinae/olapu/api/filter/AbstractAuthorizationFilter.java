package org.kushinae.olapu.api.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.kushinae.olapu.api.exceprion.UnAccessException;
import org.kushinae.olapu.api.exceprion.UnAuthorizationException;
import org.kushinae.olapu.api.http.ErrorResponse;
import org.kushinae.olapu.core.utils.JacksonUtils;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractAuthorizationFilter extends AbstractFilter {

    protected static final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    public void onError(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
        if (e instanceof UnAuthorizationException e1) {
            unauthorized(request, response, e1);
        }
        else if (e instanceof UnAccessException e1) {
            unPermissionDenied(request, response, e1);
        }
        else {
            super.onError(request, response, e);
        }
    }

    protected void unauthorized(HttpServletRequest request, HttpServletResponse response, UnAuthorizationException e) throws IOException {
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        ErrorResponse message = ErrorResponse.unauthorized().path(method, requestURI).message(e.getMessage());
        PrintWriter writer = response.getWriter();
        writer.write(JacksonUtils.toJsonString(message));
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    protected void unPermissionDenied(HttpServletRequest request, HttpServletResponse response, UnAccessException e) throws IOException {
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        ErrorResponse message = ErrorResponse.unauthorized().path(method, requestURI).message(e.getMessage());
        PrintWriter writer = response.getWriter();
        writer.write(JacksonUtils.toJsonString(message));
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

}
