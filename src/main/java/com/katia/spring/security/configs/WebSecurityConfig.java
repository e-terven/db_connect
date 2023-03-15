package com.katia.spring.security.configs;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/user/**").hasAuthority("READ PROFILE")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()  // разделитель
                //.formLogin().successHandler(successUserHandler)
                .formLogin() // или httpBasic()
                .and()
                .logout().logoutSuccessUrl("/");
    }
}
