package com.Project.EmployeeProject.init.CSV;

import com.Project.EmployeeProject.repo.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
    private final String FILE_NAME = "src/main/resources/data.csv";

    private final CSVReader csvReader;
    private final EmployeeRepository employeeRepository;

    public DBInit(CSVReader csvReader, EmployeeRepository employeeRepository) {
        this.csvReader = csvReader;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (employeeRepository.count() != 0) {
            return;
        }
        csvReader.readFromFile(FILE_NAME);
    }
}
