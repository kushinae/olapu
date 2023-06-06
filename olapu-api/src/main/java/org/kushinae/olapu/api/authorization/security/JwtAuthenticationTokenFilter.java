package org.kushinae.olapu.api.authorization.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.kushinae.olapu.api.enums.TokenType;
import org.kushinae.olapu.api.http.ErrorResponse;
import org.kushinae.olapu.api.util.AccessTokenUtils;
import org.kushinae.olapu.api.util.JWTToken;
import org.kushinae.olapu.core.utils.JacksonUtils;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final static String AUTH_HEADER = "Authorization";
    private static final TokenType tokenType = TokenType.BEARER;

    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 检查在不在白名单

        // get token from header:  Authorization: Bearer <token>
        String authHeader = request.getHeader(AUTH_HEADER);
        JWTToken jwtToken = null;
        try {
            jwtToken = AccessTokenUtils.checkAccessPurview(request.getAuthType(), authHeader, tokenType);
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("Check access purview error", e);
            }
            ErrorResponse unauthorized = ErrorResponse.unauthorized();
            unauthorized.path(request.getMethod(), request.getRequestURI()).message(e.getMessage());
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter()
                    .write(JacksonUtils.toJsonString(unauthorized));
            response.setStatus(401);
            return;
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtToken.getUsername());

        // 注意，这里使用的是3个参数的构造方法，此构造方法将认证状态设置为true
        RememberMeAuthenticationToken authentication =
                new RememberMeAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        //将认证过了凭证保存到security的上下文中以便于在程序中使用
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}