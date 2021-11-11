package com.mtbx.prgword.infra.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("mtbx.auth")
public class AuthProp {

    private String loginPageUrl;

    @Value("${spring.mvc.static-path-pattern}")
    private  String resourcesPath;


}
