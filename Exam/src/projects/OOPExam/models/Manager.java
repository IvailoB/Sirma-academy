package projects.OOPExam.models;

import java.util.List;

public interface Manager {

    void execute(String[] command);

    void addEmployee(Employee employee);

    void editEmployee(int id,String[] data);

    List<Employee> listEmployees();

    String searchEmployeeById(int id);

    String fireEmployee(int id);

    String searchEmployeeByName(String name);

    String searchDepartmentByName(String departmentName);

    void save();
}
