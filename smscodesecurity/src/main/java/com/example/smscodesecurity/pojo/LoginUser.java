package com.example.smscodesecurity.pojo;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class LoginUser implements UserDetails, CredentialsContainer {

    private String password;
    private String username;
    private Set<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    private String nickName;

    public LoginUser(){
        this("", "", true, true, true, true, null);
    }
    public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities){
        this(username, password, true, true, true, true, authorities);
    }

    public LoginUser(String username, String password, boolean enabled,  boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        if (!username.isEmpty() && !password.isEmpty()){
            this.password = password;
            this.username = username;
            this.enabled = enabled;
            this.credentialsNonExpired = credentialsNonExpired;
            this.accountNonExpired = accountNonExpired;
            this.accountNonLocked = accountNonLocked;
            this.authorities = authorities.stream().collect(Collectors.toSet());
        }
        else {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }

    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
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
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
