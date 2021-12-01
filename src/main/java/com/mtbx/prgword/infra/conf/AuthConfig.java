package com.mtbx.prgword.infra.conf;


import com.mtbx.prgword.infra.auth.handler.LoginFailHandler;
import com.mtbx.prgword.infra.auth.handler.LoginSuccessHandler;
import com.mtbx.prgword.infra.auth.provider.LoginProvider;
import com.mtbx.prgword.infra.constant.AuthProp;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 스프링 시큐리티 설정
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AuthConfig extends WebSecurityConfigurerAdapter {


    private final AuthProp authProp;
    private final UserDetailsService userDetailsService;
    private final LoginFailHandler loginFailHandler;
    private final LoginSuccessHandler loginSuccessHandler;
    private final LoginProvider loginProvider;

    /**
     * 시큐리티 빈 등록 및 패턴 설계
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http
                .formLogin()
                .failureHandler(loginFailHandler)
                .successHandler(loginSuccessHandler)
                .loginPage(authProp.getLoginPageUrl()).permitAll()
                .loginProcessingUrl("/login").permitAll();

        http.authorizeRequests()
                .mvcMatchers("/",authProp.getLoginPageUrl(),"/login" ,"/member","/member/**","/account/**","/profile/**").permitAll()
                .anyRequest().authenticated()
               ;



        http.userDetailsService(userDetailsService);
        //http.authenticationProvider(loginProvider);

    }

    /**
     * 웹 시큐리티 설정 처리
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(authProp.getResourcesPath())
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }







}
