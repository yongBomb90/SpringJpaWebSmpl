package com.mtbx.prgword.biz.member.domain;


import com.mtbx.prgword.infra.auth.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "MEMBERS")
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Builder
public class Member {

    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "MEM_NAME" , nullable = false)
    private String memName; // 로그인 아이디

    @Column(name = "MEM_TYPE" , columnDefinition = "ENUM('P','G') DEFAULT 'P' " )
    @Enumerated(EnumType.STRING)
    private MemType memType; // 로그인 아이디

    @Column(name = "DEL_YN" , columnDefinition = "ENUM('Y','N') DEFAULT 'N' " )
    @Enumerated(EnumType.STRING)
    private Account.DelYn delYn; // 삭제여부

    @Column(name = "REG_DATE" , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    private LocalDateTime regDate;

    @Column(name = "UDT_DATE" , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" )
    private LocalDateTime udtDate;

    @OneToMany(targetEntity = Account.class , mappedBy = "member")
    private List<Account> accounts;

    public enum MemType {
        P, // 개인
        G  // 그룹
        ; // 미입력
    }
}
