package org.kushinae.olapu.api.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface OlapuFilter extends Filter {

    void onError(HttpServletRequest request, HttpServletResponse response, Exception exception) throws IOException;

    void filter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException;

}
