package com.lemo.springcoredemo.rest;

import com.lemo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private  Coach anotherCoach;

//    add auto wired to can inject the dependencies
//    if i have one constructor the @Autowired is optional
    @Autowired
    public DemoController( @Qualifier("cricketCoach") Coach theCoash ,
                           @Qualifier("cricketCoach") Coach theanotherCoash)
    {
        System.out.println("In constructor  : "  + getClass().getSimpleName());
        myCoach = theCoash;
        anotherCoach = theanotherCoash;
    }
    @GetMapping("/dailyworkouts")
    public String GetDailyWorkout()
    {
            return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check()
    {
        return "Comparing beans: myCoach == anotherCoach  , " + (myCoach == anotherCoach);
    }

}
