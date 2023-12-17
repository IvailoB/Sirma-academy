package com.Project.EmployeeProject.init.CSV;

import com.Project.EmployeeProject.models.entity.Employee;
import com.Project.EmployeeProject.models.entity.Project;
import com.Project.EmployeeProject.repo.EmployeeRepository;
import com.Project.EmployeeProject.repo.ProjectRepository;
import com.Project.EmployeeProject.services.EmployeeService;
import com.Project.EmployeeProject.services.ProjectService;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
                Employee employee = new Employee();
                employee.setId(Long.parseLong(values[0]));
                employee.setStartDate(LocalDate.parse(values[2]));
                LocalDate dateTo = "null".equalsIgnoreCase(values[3]) ? null : LocalDate.parse(values[3],DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                employee.setEndDate(dateTo);
                employeeService.init(employee);

                Project project = new Project();
                project.setId(Long.parseLong(values[1]));
                projectService.init(project);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
