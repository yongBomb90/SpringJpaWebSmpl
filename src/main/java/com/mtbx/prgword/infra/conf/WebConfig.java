package com.mtbx.prgword.infra.conf;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Properties;

@Configuration
public class WebConfig extends WebMvcAutoConfiguration {

    @Value("${spring.profiles.active}")
    private String profiles;

    @Bean
    public Properties properties() throws Exception{
        // TODO : 프로파일에 따른 설정 불러오기 처리 필요
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(new ClassPathResource("props/profiles/application-"+profiles+".yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yamlPropertiesFactoryBean.getObject());
        Properties  properties = yamlPropertiesFactoryBean.getObject();
        return properties;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}
