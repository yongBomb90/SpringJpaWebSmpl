package com.mtbx.prgword.infra.auth.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class AccountUserDetail implements UserDetails {


    private Long seq;

    private String accId; // 로그인 아이디

    private String  accSec; // 로그인 비밀번호

    private AccountETT.AccType acctype; // 로그인 타입

    private AccountETT.AccRole accRole; // 로그인 타입

    private LocalDateTime lastAccDate;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =   new SimpleGrantedAuthority(accRole.name());
        return List.of(authority);
    }

    @Override
    public String getPassword() {
        return "{noop}"+accSec;
    }

    @Override
    public String getUsername() {
        return accId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Entity TO UserDetail
     * @param accountETT
     * @return
     */
    public static AccountUserDetail of(AccountETT accountETT) {
        if ( accountETT == null) {
            return null;
        }
        return new ModelMapper().map(accountETT, AccountUserDetail.class);
    }
}
