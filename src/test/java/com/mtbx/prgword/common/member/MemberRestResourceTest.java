package com.mtbx.prgword.common.member;

import com.mtbx.prgword.biz.member.controller.MemberRestResource;
import com.mtbx.prgword.biz.member.domain.Member;
import com.mtbx.prgword.common.PrgWordTest;
import com.mtbx.prgword.infra.auth.domain.Account;
import com.mtbx.prgword.infra.auth.repo.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MimeType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


public class MemberRestResourceTest extends PrgWordTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    MemberRestResource memberRestResource;
    @Autowired
    AccountRepository accountRepository;


    /**
     * @throws Exception
     */
    @Test
    @DisplayName("유저생성")
    void createMemberForm() throws Exception {

        Member member = Member.builder()
                .memType(Member.MemType.P)
                .memName("테스트계정").build();
        member = memberRestResource.save(member);

        /**
         * 관계의 주인이 ACCOUNT 이기 때문에 멤버가 생성된후 생성되어야한다.
         */
        Account account = Account.builder()
                .accId("thisIsMe")
                .accSec("qwer1234")
                .acctype(Account.AccType.A)
                .build();
        account.setMember(member);
        accountRepository.save(account);

    }


    

}
