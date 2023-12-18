package com.Project.EmployeeProject.init.CSV;

import com.Project.EmployeeProject.models.entity.Employee;
import com.Project.EmployeeProject.models.entity.Project;
import com.Project.EmployeeProject.services.EmployeeService;
import com.Project.EmployeeProject.services.ProjectService;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

@Component
public class CSVReader {

    private final EmployeeService employeeService;
    private final ProjectService projectService;

    public CSVReader(EmployeeService employeeService, ProjectService projectService) {
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    public void readFromFile(String FILE_NAME) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            // Skip the header
            reader.readLine();
            // Reading data
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(", ");
                Long userId = Long.parseLong(values[0]);
                Long projectId = Long.parseLong(values[1]);
                LocalDate startDate = LocalDate.parse(values[2]);
                LocalDate dateTo = "null".equalsIgnoreCase(values[3]) ? null : LocalDate.parse(values[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                Employee employee = getEmployee(userId, startDate, dateTo);
                Project project = getProject(projectId);

                employee.getProjects().add(project);
                employeeService.init(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Project getProject(Long projectId) {
        return projectService.findById(projectId)
                .orElseGet(() -> {
                    Project newProject = new Project();
                    newProject.setId(projectId);
                    projectService.init(newProject);
                    return newProject;
                });
    }

    private Employee getEmployee(Long userId, LocalDate startDate, LocalDate dateTo) {
        return employeeService.findById(userId)
                .orElseGet(() -> {
                    Employee newEmployee = new Employee();
                    newEmployee.setId(userId);
                    newEmployee.setStartDate(startDate);
                    newEmployee.setEndDate(dateTo);
                    newEmployee.setProjects(new HashSet<>());
                    return newEmployee;
                });
    }
}
