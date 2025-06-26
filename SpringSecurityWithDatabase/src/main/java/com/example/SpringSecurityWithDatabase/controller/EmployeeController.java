package com.example.SpringSecurityWithDatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurityWithDatabase.model.Employee;
import com.example.SpringSecurityWithDatabase.service.EmployeeService;

@RestController
@RequestMapping("/api/user")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/get")
    public String get(){
        return "Get Method";
    }

    @PostMapping("/post")
    public Employee post(@RequestBody Employee employee){
        System.out.println("Received password: " + employee.getPassword());
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeService.postEmployee(employee);
    }

    @GetMapping("/user/get")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }

    @GetMapping("/dashboard")
    public String dash(){
        return "Login Successful...";
    }
}
