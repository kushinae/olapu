package org.kushinae.olapu.api.pojo.account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class AccountDetails implements UserDetails {

    private String password;

    private String username;

    private Boolean expired;

    private Boolean locked;

    private Boolean enabled;

    public static AccountDetails build() {
        return new AccountDetails();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public AccountDetails password(String password) {
        this.password = password;
        return this;
    }

    public AccountDetails username(String username) {
        this.username = username;
        return this;
    }

    public AccountDetails expired(Boolean expired) {
        this.expired = expired;
        return this;
    }

    public AccountDetails locked(Boolean locked) {
        this.locked = locked;
        return this;
    }

    public AccountDetails enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}
