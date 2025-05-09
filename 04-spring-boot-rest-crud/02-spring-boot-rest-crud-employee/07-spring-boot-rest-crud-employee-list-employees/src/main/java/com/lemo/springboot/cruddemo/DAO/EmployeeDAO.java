package com.lemo.springboot.cruddemo.DAO;

import com.lemo.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
