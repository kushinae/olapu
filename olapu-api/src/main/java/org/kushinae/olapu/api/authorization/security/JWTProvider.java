package org.kushinae.olapu.api.authorization.security;

import org.kushinae.olapu.api.exceprion.AccessTokenException;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JWTProvider extends DaoAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = getUserDetailsService().loadUserByUsername(username);
        if (userDetails.getPassword().equals(password)) {
            return new RememberMeAuthenticationToken(username, password, userDetails.getAuthorities());
        }
        throw new AccessTokenException(ErrorMessage.AUTHENTICATION_FAILED);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
