package com.mtbx.prgword.infra.auth.provider;

import com.mtbx.prgword.infra.auth.domain.AccountUserDetail;
import com.mtbx.prgword.infra.auth.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginProvider implements AuthenticationProvider {

    private final AccountService userDetailsService;

    @Override
    public boolean supports(Class<?> authentication) {
        return  authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = authentication.getName();
        String password = authentication.getCredentials().toString();
        if ( id == null || password == null ) {
            throw new UsernameNotFoundException("params is null ");
        }
        AccountUserDetail accountUserDetail = (AccountUserDetail)userDetailsService.loadUserByUsername(id);
        if ( accountUserDetail.getAccSec().equals(password)) {
            return new RememberMeAuthenticationToken(accountUserDetail.getAccId(),accountUserDetail.getAccSec(),accountUserDetail.getAuthorities());
        }
        return null;
    }


}
