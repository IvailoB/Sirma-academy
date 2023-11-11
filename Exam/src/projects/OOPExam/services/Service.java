package projects.OOPExam.services;

import projects.OOPExam.models.Employee;

import java.util.List;

public interface Service {
    List<Employee> readData();

    void writeData();

    void editEmployee(int id,String[] data);

    void fireEmployee(int id);

    void save();

    void addEmployee(Employee employee);

    List<Employee> searchDepartmentByName(String departmentName);

    Employee searchEmployeeByName(String name);

    Employee searchEmployeeById(int id);
}
