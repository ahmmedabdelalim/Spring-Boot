package com.lemo.springboot.cruddemo.rest;

import com.lemo.springboot.cruddemo.entity.Employee;
import com.lemo.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService ;

//    quick and dirty : use the constructor injection

    public EmployeeRestController(EmployeeService theEmployeeService)
    {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }
}
