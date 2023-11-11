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
    public void execute(String command) {
        Scanner scanner = new Scanner(System.in);
        switch (command) {
//            int id = -1;
            case "Add Employee":
                String[] data = scanner.nextLine().split(", ");
                Employee employee = createEmployee(data);
                addEmployee(employee);
                break;
//            case "Edit":
//                id = scanner.nextInt();
//                editEmployee(id);
//                break;
//            case "List employees":
//                listEmployees();
//                break;
//            case "Search Department Marketing":
//                break;
//            case "Search Id":
//                id = scanner.nextInt();
//                searchEmployee(id);
//                break;
//            case "Fire 1":
//                fireEmployee(id);
//                break;
//            case "Search Name []]":
//                searchEmployeeByName(name);
//                break;
//            case "Save & Exit":
//                save();
//                break;
            default:
                System.out.println("Invalid command!");
                System.out.println("Please check and try again");
        }
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
        service.writeData(employee);
    }

    @Override
    public void editEmployee(int id) {

    }

    @Override
    public List<Employee> listEmployees() {
        return null;
    }

    @Override
    public Employee searchEmployee(int id) {
        return null;
    }

    @Override
    public void fireEmployee(int id) {

    }

    @Override
    public Employee searchEmployeeByName(String name) {
        return null;
    }

    @Override
    public void save() {

    }
}
