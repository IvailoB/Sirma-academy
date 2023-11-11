package projects.OOPExam.models;

import projects.OOPExam.services.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

//import projects.OOPExam.constants.Messages;??

public class StaffManager implements Manager {
    public final String INVALID_EMPLOYEE_ID = "There is no employee with that id";
    public final String INVALID_EMPLOYEE_NAME = "There is no employee with that id";
    public final String INVALID_DEPARTMENT_NAME = "There is no department with that name";
    public final String VALID_DEPARTMENT_NAME = "There is departments with that name";
    public final String INVALID_COMMAND = "Invalid command! \nPlease check and try again\n";

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
                        System.out.println(searchEmployeeByName(employeeName));
                        break;
                    case "Department":
                        String departmentName = command[2];
                        searchDepartmentByName(departmentName);
                        break;
                    case "Id":
                        id = Integer.parseInt(command[2]);
                        System.out.println(searchEmployeeById(id));
                        break;
                }
                break;

            case "Save":
                save();
                return;
            default:
                System.out.println(INVALID_COMMAND);
        }
    }

    public String searchDepartmentByName(String departmentName) {
        if (!service.searchDepartmentByName(departmentName).isEmpty()) {
            List<Employee> employees = service.searchDepartmentByName(departmentName);
            employees.forEach(System.out::println);
            return VALID_DEPARTMENT_NAME;
        }
        return INVALID_DEPARTMENT_NAME;
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
    public String searchEmployeeById(int id) {
        if (service.searchEmployeeById(id) != null) {
            return service.searchEmployeeById(id);
        }
        return INVALID_EMPLOYEE_ID;
    }

    @Override
    public String fireEmployee(int id) {
        if (service.fireEmployee(id) != null) {
            service.fireEmployee(id);
        }

        return INVALID_EMPLOYEE_ID;
    }

    @Override
    public String searchEmployeeByName(String name) {
        if (service.searchEmployeeByName(name) != null) {
            return service.searchEmployeeByName(name);
        }
        return INVALID_EMPLOYEE_NAME;
    }

    @Override
    public void save() {
        service.save();
    }
}
