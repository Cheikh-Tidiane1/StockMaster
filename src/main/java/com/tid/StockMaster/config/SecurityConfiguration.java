package com.tid.StockMaster.config;

import com.tid.StockMaster.services.auth.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize-> authorize.requestMatchers("/authenticate/**").permitAll()
                        .anyRequest().authenticated());
       return http.build();
    }

    @Bean
    public ApplicationUserDetailsService userDetailsService() {
        return userDetailsService;
    }

}
