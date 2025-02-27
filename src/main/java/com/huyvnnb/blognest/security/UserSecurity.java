package com.huyvnnb.blognest.security;

import com.huyvnnb.blognest.entity.User;
import com.huyvnnb.blognest.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserSecurity implements UserDetails {
    String email;
    String password;
    List<? extends GrantedAuthority> authorities;

    public UserSecurity(User user){
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.authorities = List.of(new SimpleGrantedAuthority(user.getRole().name()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
