package com.capstone.backend.security;


import com.capstone.backend.security.filter.AuthenticationFilter;
import com.capstone.backend.security.filter.CorsFilter;
import com.capstone.backend.security.filter.JWTAuthorizationFilter;
import com.capstone.backend.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
    CustomAuthenticationManager customAuthenticationManager;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        CorsFilter corsFilter = new CorsFilter();
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/authenticate");
        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests(authorizeRequests -> authorizeRequests
                .antMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll() // Allows anyone to make post request on the path sign-up/register
                .anyRequest().authenticated() )// requires that all requests (other than antMatcher specified requests) be authenticated
//                .addFilterBefore()
                .addFilterBefore(new CorsFilter(), AuthenticationFilter.class)
                .addFilter(authenticationFilter)
                .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

}