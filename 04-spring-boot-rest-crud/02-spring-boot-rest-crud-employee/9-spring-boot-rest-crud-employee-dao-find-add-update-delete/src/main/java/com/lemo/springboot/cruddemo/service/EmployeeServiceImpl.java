package com.lemo.springboot.cruddemo.service;

import com.lemo.springboot.cruddemo.DAO.EmployeeDAO;
import com.lemo.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO)
    {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
      return  employeeDAO.findAll();
    }
}
