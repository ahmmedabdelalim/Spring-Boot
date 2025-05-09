package com.lemo.springboot.cruddemo.rest;

import com.lemo.springboot.cruddemo.DAO.EmployeeDAO;
import com.lemo.springboot.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeDAO employeeDAO ;

//    quick and dirty : use the constructor injection

    public EmployeeRestController(EmployeeDAO theEmployeeDAO)
    {
        employeeDAO = theEmployeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeDAO.findAll();
    }
}
