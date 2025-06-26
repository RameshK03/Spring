package com.example.SpringSecurityWithDatabase.userAuth;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SpringSecurityWithDatabase.model.Employee;
import com.example.SpringSecurityWithDatabase.repository.EmployeeRepository;

@Service
public class EmployeeDetailsStorage implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepo.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User Name not Found"));
        
        return new User(employee.getUsername(), employee.getPassword(), new ArrayList<>());
    }
}
