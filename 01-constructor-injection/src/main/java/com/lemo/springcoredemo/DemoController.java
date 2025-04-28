package com.lemo.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

//    add auto wired to can inject the dependencies
//    if i have one constructor the @Autowired is optional
@Autowired
    public DemoController (Coach theCoach)
    {
        myCoach = theCoach;
    }
@GetMapping("/dailyworkouts")
    public String GetDailyWorkout()
    {
        return myCoach.getDailyWorkout();
    }

}
