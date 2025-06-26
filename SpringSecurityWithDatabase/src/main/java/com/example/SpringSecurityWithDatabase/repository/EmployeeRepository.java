package com.example.SpringSecurityWithDatabase.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringSecurityWithDatabase.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
   public Optional<Employee> findByUsername(String username);
}
