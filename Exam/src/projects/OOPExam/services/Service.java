package projects.OOPExam.services;

import projects.OOPExam.models.Employee;

import java.util.List;

public interface Service {
    List<Employee> readData();

    void writeData();

    void editEmployee(int id,String[] data);

    String fireEmployee(int id);

    void save();

    void addEmployee(Employee employee);

    List<Employee> searchDepartmentByName(String departmentName);

    String searchEmployeeByName(String name);

    String searchEmployeeById(int id);
}
