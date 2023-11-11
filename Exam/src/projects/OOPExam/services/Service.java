package projects.OOPExam.services;

import projects.OOPExam.models.Employee;

import java.util.List;

public interface Service {
    List<Employee> readData(String FILE_NAME);

    void writeData(Employee employee);
}
