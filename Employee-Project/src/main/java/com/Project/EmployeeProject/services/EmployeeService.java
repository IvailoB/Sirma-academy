package com.Project.EmployeeProject.services;

import com.Project.EmployeeProject.models.entity.Employee;
import com.Project.EmployeeProject.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void init(Employee employee) {
        if (employeeRepository.count() != 0) {
            return;
        }
        employeeRepository.save(employee);
    }
}
