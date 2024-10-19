package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        //  http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());
        // http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll();

        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/getCards", "/myAccount", "/myBalance", "/getLoans", "/getNotices").authenticated().requestMatchers("/welcome", "/contactus").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User.withUsername("user").password("{bcrypt}$2a$12$2ADikURsxbMKeSwUulUGWejdXvCdHd8mhIpyB.ZipxSSe/JoiZHNi").authorities("read").build();
        UserDetails admin = User.withUsername("admin").password("{bcrypt}$2a$12$J9qv6hgWiOfOdN9RQnzfe.YyrTDEECdd5DsmNOR1dxIv25U9E/gvu").authorities("admin").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
