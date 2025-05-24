package com.lemo.springboot.cruddemo.JpaRepository;

import com.lemo.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
                                                                    // Integer for primary Key
public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
}
