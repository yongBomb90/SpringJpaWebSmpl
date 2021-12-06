package com.mtbx.prgword.infra.auth.domain;

import com.mtbx.prgword.biz.member.domain.Member;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 계정 생성시 사용할 DTO
 * 정책에 따라 Map으로 변경 처리 현재 TODO로 남겨둠
 */
@Data
public class AccountDTO {

    private String accId; // 로그인 아이디

    private String  accSec; // 로그인 비밀번호

    private Account.AccType acctype; // 로그인 타입

    private String memName; // 로그인 아이디

    private Member.MemType memType; // 로그인 아이디

}
