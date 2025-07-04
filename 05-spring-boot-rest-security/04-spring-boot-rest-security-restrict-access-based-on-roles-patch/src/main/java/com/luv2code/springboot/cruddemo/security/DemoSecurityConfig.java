package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails john = User.builder().username("john")
                .password("{noop}123456").roles("EMPLOYEE").build();

        UserDetails mary = User.builder().username("mary")
                .password("{noop}123456").roles("MANAGER").build();

        UserDetails sousan = User.builder().username("sousan")
                .password("{noop}123456").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(john, mary , sousan);
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET , "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET , "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST , "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT , "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH , "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE , "/api/employees/**").hasRole("ADMIN")
        );
//        use http basic auth
        http.httpBasic(Customizer.withDefaults());
        // disable cross site reequest forgery
            http.csrf(csrf->csrf.disable());

            return http.build();
    }
}
