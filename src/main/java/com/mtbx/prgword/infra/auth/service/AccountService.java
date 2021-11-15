package com.mtbx.prgword.infra.auth.service;

import com.mtbx.prgword.infra.auth.domain.AccountETT;
import com.mtbx.prgword.infra.auth.domain.AccountUserDetail;
import com.mtbx.prgword.infra.auth.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountETT accountETT =  accountRepository.getByAccIdEquals(username);
        if ( accountETT == null ) {
            throw new UsernameNotFoundException(username);
        }
        AccountUserDetail userDetail = AccountUserDetail.of(accountETT);
        return userDetail;
    }

}
