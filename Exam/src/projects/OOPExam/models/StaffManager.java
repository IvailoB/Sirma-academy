package projects.OOPExam.models;

import projects.OOPExam.services.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StaffManager implements Manager {
    private Service service;

    public StaffManager(Service service) {
        this.service = service;
    }


    @Override
    public void execute(String[] command) {
        Scanner scanner = new Scanner(System.in);
        String[] data;
        String action = command[0];
        String secondAction = command[1];
        int id;
        switch (action) {

            case "Add":
                data = scanner.nextLine().split(", ");
                Employee employee = createEmployee(data);
                addEmployee(employee);
                break;
            case "Edit":
                id = Integer.parseInt(command[1]);
                data = scanner.nextLine().split(", ");
                editEmployee(id, data);
                break;
            case "List":
                listEmployees().forEach(System.out::println);
                break;

            case "Fire":
                id = Integer.parseInt(command[1]);
                fireEmployee(id);
                break;

            case "Search":
                switch (secondAction) {
                    case "Name":
                        String employeeName = command[2];
                        searchEmployeeByName(employeeName);
                        break;
                    case "Department":
                        String departmentName = command[2];
                        searchDepartmentByName(departmentName);
                        break;
                    case "Id":
                        id = Integer.parseInt(command[2]);
                        searchEmployee(id);
                        break;
                }
                break;

            case "Save & Exit":
                save();
                return;
            default:
                System.out.println("Invalid command!");
                System.out.println("Please check and try again");
        }
    }

    private void searchDepartmentByName(String departmentName) {
        service.searchDepartmentByName(departmentName);
    }

    public Employee createEmployee(String[] data) {
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        String department = data[2];
        String role = data[3];
        double salary = Double.parseDouble(data[4]);
        String startDate = LocalDate.now().toString();

        return new Employee(id, name, startDate, null, department, role, salary);
    }

    @Override
    public void addEmployee(Employee employee) {
        service.addEmployee(employee);
    }

    @Override
    public void editEmployee(int id, String[] data) {
        service.editEmployee(id, data);
    }

    @Override
    public List<Employee> listEmployees() {
        return service.readData();
    }

    @Override
    public Employee searchEmployee(int id) {
        return service.searchEmployeeById(id);
    }

    @Override
    public void fireEmployee(int id) {
        service.fireEmployee(id);
    }

    @Override
    public Employee searchEmployeeByName(String name) {
        return service.searchEmployeeByName(name);
    }

    @Override
    public void save() {
        service.save();
    }
}
