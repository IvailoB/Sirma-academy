package com.Project.EmployeeProject.controllers;

import com.Project.EmployeeProject.models.entity.Employee;
import com.Project.EmployeeProject.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employee/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @PostMapping("/employee/add")
    @Validated
    public String addEmployee(@Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        employeeService.init(employee);
        return "redirect:/";
    }

    @GetMapping("/employee/edit/{id}")
    @Validated
    public String editEmployeeForm(@Valid @PathVariable Long id, Model model) {
        try {
            model.addAttribute("employee", employeeService.findById(id));
        } catch (Exception exception) {
            model.addAttribute("error", exception.getMessage());
            return "redirect:/";
        }
        return "edit";
    }

    @PostMapping("/employee/edit/{id}")
    @Validated
    public String editEmployee(@PathVariable Long id, @Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit";
        }
        employeeService.init(employee);
        return "redirect:/";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/";
    }


//TODO @GetMapping("/employee/sort")
//    public String sortEmployees(@PathVariable Long id) {
//        employeeService.sort(id);
//        return "redirect:/";
//    }
}
