package com.lemo.springboot.cruddemo.service;

import com.lemo.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
