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

    /**
     * 异常处理
     *
     * @param request 请求对象
     * @param response 响应对象
     * @param exception 抛出的异常
     * @throws IOException 写响应是流已经被关闭可能会抛出这个异常
     */
    void onError(HttpServletRequest request, HttpServletResponse response, Exception exception) throws IOException;

    /**
     * 内部拦截器实现
     *
     * @param request 请求对象
     * @param response 响应对象
     * @param chain 执行链对象
     * @throws IOException 写响应是流已经被关闭可能会抛出这个异常
     * @throws ServletException servlet 在遇到困难时可以抛出的一般异常。
     */
    void filter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException;

}
