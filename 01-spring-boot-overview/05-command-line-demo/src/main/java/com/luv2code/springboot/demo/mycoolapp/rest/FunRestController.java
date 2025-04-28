package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // return hello world
    @Value("${myname}")
    private String Myname;
@GetMapping("/")
    public String sayHello()
    {
            return "Mynssssssssame" ;
    }

    @GetMapping("/workout")
    public String getDailyWorkOut()
    {
        return "Run hard and not easy";
    }

}

