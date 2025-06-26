package com.example.SpringSecurityWithDatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.SpringSecurityWithDatabase.userAuth.EmployeeDetailsStorage;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authz ->
        authz
        .requestMatchers(HttpMethod.POST,"api/post").permitAll()
        .requestMatchers("/api/user/**").authenticated()
        .requestMatchers("api/get").permitAll()
        .anyRequest().permitAll()
        )
        .formLogin(form -> form.permitAll()
        .defaultSuccessUrl("/api/dashboard",true))
        .csrf( csrf -> csrf.disable());
    
        return http.build();
    }

    @Bean
    public UserDetailsService EmployeeDetailsService(){
        return new EmployeeDetailsStorage();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(EmployeeDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
