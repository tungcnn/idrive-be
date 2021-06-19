package com.hanoi.heat.idrive.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable()
                .authorizeRequests().antMatchers("/auth/**", "/vehicle/", "/vehicles/**", "/vehicles","/Order/**").permitAll()
                .and()
                .authorizeRequests().antMatchers( "/review/**").hasAnyRole("USER")
                .anyRequest()
                .authenticated();
    }
}
