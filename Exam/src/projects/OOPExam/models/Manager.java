package projects.OOPExam.models;

import java.util.List;

public interface Manager {

    void execute(String[] command);

    void addEmployee(Employee employee);

    void editEmployee(int id,String[] data);

    List<Employee> listEmployees();

    Employee searchEmployee(int id);

    void fireEmployee(int id);

    Employee searchEmployeeByName(String name);

    void save();
}
