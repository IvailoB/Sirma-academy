package projects.OOPExam.CSV;

import projects.OOPExam.models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {


    public void writeData(Employee newEmployee, String FILE_NAME, List<Employee> oldContent) {

        List<Employee> allEmployees = new ArrayList<>(oldContent);
        allEmployees.add(newEmployee);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            // Writing header
            writer.write("Id,Name,StartDate,EndDate,Department,Role,Salary");
            writer.newLine();

            // Writing data
            for (Employee employee : allEmployees) {
                String line = String.format(
                        "%d,%s,%s,%s,%s,%s,%.2f",
                        employee.getId(),
                        employee.getName(),
                        employee.getStartDate(),
                        employee.getEndDate(),
                        employee.getDepartment(),
                        employee.getRole(),
                        employee.getSalary()
                );
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
