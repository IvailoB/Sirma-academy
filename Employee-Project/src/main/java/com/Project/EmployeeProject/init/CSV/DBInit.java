package com.Project.EmployeeProject.init.CSV;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
    private final String FILE_NAME = "src/main/resources/data.csv";

    private final CSVReader csvReader;

    public DBInit(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public void run(String... args) throws Exception {
        csvReader.readFromFile(FILE_NAME);
    }
}
