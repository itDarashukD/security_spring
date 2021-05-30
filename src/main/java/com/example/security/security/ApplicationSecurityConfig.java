package com.example.security.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception { //спрашивает пароль при запросе http,  пароль записан в консоли при загрузке апп
        http.authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*")// on this page password do not needs/"/8080"
                .permitAll()//index - file from resouces/static
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
