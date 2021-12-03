package com.mtbx.prgword.common.account;

import com.mtbx.prgword.biz.member.controller.MemberRestResource;
import com.mtbx.prgword.biz.member.domain.Member;
import com.mtbx.prgword.common.PrgWordTest;
import com.mtbx.prgword.infra.auth.domain.Account;
import com.mtbx.prgword.infra.auth.repo.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


public class AccountControllerTest extends PrgWordTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    AccountRepository accountRepository;


    /**
     * @throws Exception
     */
    @Test
    @DisplayName("fetch join 확인")
    @Transactional
    void searchLogin() throws Exception {
        Account account = accountRepository.getByAccIdEqualsWithMember("thisIsMe");
        Assert.isTrue(account.getAccId().equals("thisIsMe"));

    }


    

}
