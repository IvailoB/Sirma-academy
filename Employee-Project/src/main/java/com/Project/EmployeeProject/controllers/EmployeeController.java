package com.Project.EmployeeProject.controllers;

import com.Project.EmployeeProject.models.entity.Employee;
import com.Project.EmployeeProject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployee();

        model.addAttribute("employees", allEmployees);
        return "home";
    }
}
