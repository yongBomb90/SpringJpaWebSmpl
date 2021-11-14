package com.mtbx.prgword.infra.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/***
 * 앱 권한 프로퍼티 상수
 */
@Data
@Component
@ConfigurationProperties("mtbx.auth")
public class AuthProp {

    private String loginPageUrl; // 로그인 페이지 주소


    /****************************************************
     * 스프링 설정 상수
     *****************************************************/
    @Value("${spring.mvc.static-path-pattern}")
    private  String resourcesPath; // 리소스 주소


}
