package com.mtbx.prgword.infra.auth.domain;


import lombok.Data;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 로그인 데이터
 */
@Data
@Entity
@Table(name = "ACCOUNT")
public class AccountETT {

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

    @Column(name = "DEL_YN" , columnDefinition = "ENUM('Y','N') DEFAULT 'N' " , nullable = false)
    @Enumerated(EnumType.STRING)
    private DelYn delYn; // 삭제여부

    @Column(name = "REG_DATE" , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" , nullable = false)
    private LocalDateTime regDate;

    @Column(name = "UDT_DATE" , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" , nullable = false)
    private LocalDateTime udtDate;

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



}
