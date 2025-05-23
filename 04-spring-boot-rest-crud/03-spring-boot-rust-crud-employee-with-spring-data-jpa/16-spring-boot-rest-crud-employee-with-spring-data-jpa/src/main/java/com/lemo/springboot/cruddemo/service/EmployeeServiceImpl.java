package com.lemo.springboot.cruddemo.service;

import com.lemo.springboot.cruddemo.DAO.EmployeeDAO;
import com.lemo.springboot.cruddemo.JpaRepository.EmployeeRepository;
import com.lemo.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO , EmployeeRepository theEmployeeRepository)
    {
        employeeDAO = theEmployeeDAO;
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
      return  employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }
    

    @Override
    public Employee save(Employee theEmployee) {

        return employeeRepository.save(theEmployee);
    }


    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
