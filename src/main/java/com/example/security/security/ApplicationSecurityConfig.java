package com.example.security.security;


import com.example.security.role.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.security.role.ApplicationUserRole.ADMIN;
import static com.example.security.role.ApplicationUserRole.STUDENT;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { //спрашивает пароль при запросе http,  пароль записан в консоли при загрузке апп
        http.authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*")// on this page password do not needs/"/8080"
                .permitAll()//index - file from resouces/static
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {  //We created user
        UserDetails annaSmithUser = User.builder()
                .username("annaSmith")
                .password(passwordEncoder.encode("password")) //aply to "password" BC encoding
                // now enter http request only with name/password, password automatically encoded with BCryption
                .roles(STUDENT.name()) //  //his role student
                .build();

        UserDetails linda = User.builder()  //create second user
                .username("linda")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN.toString())   //his role administrator
                .build();

        return new InMemoryUserDetailsManager(
                annaSmithUser
                ,linda);
    }
}
