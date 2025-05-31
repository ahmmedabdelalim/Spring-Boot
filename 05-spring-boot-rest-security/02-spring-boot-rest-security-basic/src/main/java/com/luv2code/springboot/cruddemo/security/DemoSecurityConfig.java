package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails john = User.builder().username("john")
                .password("{noop}123456").roles("Admin").build();
        UserDetails mary = User.builder().username("mary")
                .password("{noop}123456").roles("Admin").build();
        UserDetails sousan = User.builder().username("sousan")
                .password("{noop}123456").roles("Admin").build();

        return new InMemoryUserDetailsManager(john, mary , sousan);
    }
}
