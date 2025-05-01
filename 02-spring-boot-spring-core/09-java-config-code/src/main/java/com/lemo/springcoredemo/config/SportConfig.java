package com.lemo.springcoredemo.config;

import com.lemo.springcoredemo.common.Coach;
import com.lemo.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
// give the bean id
    @Bean("testbean")
    public Coach SwimCoach()
    {
        return new SwimCoach();
    }
}
