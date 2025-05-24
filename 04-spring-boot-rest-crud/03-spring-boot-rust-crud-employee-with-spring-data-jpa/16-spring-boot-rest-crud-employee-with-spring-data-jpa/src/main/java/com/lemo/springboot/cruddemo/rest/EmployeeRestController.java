package com.lemo.springboot.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lemo.springboot.cruddemo.entity.Employee;
import com.lemo.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService ;

    // create private attribute to use patch
    private ObjectMapper objectMapper;

//    quick and dirty : use the constructor injection

    public EmployeeRestController(EmployeeService theEmployeeService , ObjectMapper theObjectMapper)
    {
        employeeService = theEmployeeService;
        objectMapper = theObjectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeid}")
    public Employee getEmployee(@PathVariable int employeeid )
    {
        Employee theEmployee = employeeService.findById(employeeid);

        if(theEmployee == null)
        {
                throw new RuntimeException("Emplyee Not Found");
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        // set the id as 0 to force save not update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee dbEmployee = employeeService.save(theEmployee);

        return  dbEmployee;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId , @RequestBody Map<String, Object> patchPayLoad)
    {
        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if data is null
        if(tempEmployee == null)
        {
            throw new RuntimeException("employee not found "+ employeeId);
        }

        // throw exception if the patch load conatin the fild id
        if (patchPayLoad.containsKey("id"))
        {
            throw new RuntimeException("the Id not allowed to change");
        }

        Employee patchedEmployee = apply(patchPayLoad, tempEmployee);

        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;

    }

    private Employee apply(Map<String, Object> patchPayLoad, Employee tempEmployee) {

        // first convert the object data of employee to Json
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee , ObjectNode.class);

        // convert the patchload to Json
        ObjectNode patchNode = objectMapper.convertValue(patchPayLoad , ObjectNode.class);

        // merge the patch update into the employee Node

        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode , Employee.class);
    }

    @DeleteMapping("/employee/{employeeId}")
    public String  deleteEmployee(@PathVariable int employeeId)
    {
        Employee employee = employeeService.findById(employeeId);

        if(employee == null)
        {
            throw new RuntimeException("Employee Not found " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee  - " + employeeId;

    }
}
