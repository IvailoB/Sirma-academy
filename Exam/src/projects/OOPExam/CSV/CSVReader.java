package projects.OOPExam.CSV;

import projects.OOPExam.models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public List<Employee> readData(String FILE_NAME) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            // Skip the header
            reader.readLine();

            // Reading data
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                // Assuming Employee class has a constructor that takes these values
                Employee employee = new Employee(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        values[3],
                        values[4],
                        values[5],
                        Double.parseDouble(values[6])
                );
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }
}


