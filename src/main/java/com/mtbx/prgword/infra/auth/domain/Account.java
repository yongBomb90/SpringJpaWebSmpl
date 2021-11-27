package com.mtbx.prgword.infra.auth.domain;


import com.mtbx.prgword.biz.member.domain.Member;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 로그인 데이터
 */
@Data
@Entity
@Table(name = "ACCOUNTS")
public class Account {

    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "ACC_ID" , unique = true , nullable = false)
    private String accId; // 로그인 아이디

    @Column(name = "ACC_SEC" , nullable = false)
    private String  accSec; // 로그인 비밀번호

    @Column(name = "ACC_TYPE" , columnDefinition = "ENUM('M','A','K','N','F') DEFAULT 'M' " , nullable = false)
    @Enumerated(EnumType.STRING)
    private AccType acctype; // 로그인 타입

    @Column(name = "ACC_ROLE" , columnDefinition = "ENUM('ROLE_USER','ROLE_ADMIN') DEFAULT 'ROLE_USER' " , nullable = false)
    @Enumerated(EnumType.STRING)
    private AccRole accRole; // 로그인 타입

    @Column(name = "DEL_YN" , columnDefinition = "ENUM('Y','N') DEFAULT 'N' " , nullable = false)
    @Enumerated(EnumType.STRING)
    private DelYn delYn; // 삭제여부

    @Column(name = "LAST_ACC_DATE" , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" , nullable = false)
    private LocalDateTime lastAccDate;

    @Column(name = "REG_DATE" , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" , nullable = false)
    private LocalDateTime regDate;

    @Column(name = "UDT_DATE" , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" , nullable = false)
    private LocalDateTime udtDate;

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "MEM_SEQ")
    private Member member;

    // TODO : 멤버 맵핑 필요
    public enum AccType {
        M, // 계정
        K, // 카카오
        N, // 네이버
        F, // 패에스북
        A  // 애플
        ; // 미입력
    }
    public enum DelYn {
        Y,  // 삭제
        N   // 사용중
    }

    public enum AccRole {
        ROLE_USER,  // 삭제
        ROLE_ADMIN   // 사용중
    }

    /**
     * Entity TO UserDetail
     * @param accountUserDetail
     * @return
     */
    public static Account of(AccountUserDetail accountUserDetail) {
        if ( accountUserDetail == null) {
            return null;
        }
        return new ModelMapper().map(accountUserDetail, Account.class);
    }


}
