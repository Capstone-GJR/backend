package com.capstone.backend.security;


import com.capstone.backend.security.filter.AuthenticationFilter;
import com.capstone.backend.security.filter.ExceptionHandlerFilter;
import com.capstone.backend.security.filter.JWTAuthorizationFilter;
import com.capstone.backend.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig {
    CustomAuthenticationManager customAuthenticationManager;

    /*
    @Bean
    CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://traqura.xyz"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
       configuration.setAllowedHeaders(Arrays.asList("*"));
       configuration.addAllowedHeader("Authorization");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
	System.out.println("allowed headers " + source.getCorsConfigurations().get("/**").getAllowedHeaders());
        return source;
    }
*/
    // .cors(Customizer.withDefaults())
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/authenticate");
        http
		.cors().and()
                .csrf().disable()
                .authorizeRequests(authorizeRequests -> authorizeRequests
		.antMatchers(HttpMethod.OPTIONS, "/authenticate").permitAll()
                .antMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll()
                .antMatchers(HttpMethod.POST, "/authenticate").permitAll()
                .antMatchers(HttpMethod.GET, SecurityConstants.TEST_PATH).permitAll()
                        // Allows anyone to make post request on the path sign-up/register
                .anyRequest().authenticated() )// requires that all requests (other than antMatcher specified requests) be authenticated
                .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
                .addFilter(authenticationFilter)
                .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
}