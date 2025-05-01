package com.lemo.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {
    public CricketCoach()
    {
        System.out.println("In constructor  : "  + getClass().getSimpleName());
    }
//    define init method
    @PostConstruct
    public void doMystartupStuff()
    {
        System.out.println("In doMyStartupStuff(): "  + getClass().getSimpleName());
    }
//    define destory method
    @PreDestroy
    public void doMuCleanupStuff()
    {
        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 minutes -:)";
    }
}
