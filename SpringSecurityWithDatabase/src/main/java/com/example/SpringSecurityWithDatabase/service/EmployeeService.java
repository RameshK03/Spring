package com.example.SpringSecurityWithDatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringSecurityWithDatabase.model.Employee;
import com.example.SpringSecurityWithDatabase.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepo;

    
    public List<Employee> getEmployee() {
        return employeeRepo.findAll();
    }


    public Employee postEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
}
