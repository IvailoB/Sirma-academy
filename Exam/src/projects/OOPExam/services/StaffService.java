package projects.OOPExam.services;

import projects.OOPExam.CSV.CSVReader;
import projects.OOPExam.CSV.CSVWriter;
import projects.OOPExam.models.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class StaffService implements Service {

    private static final String FILE_NAME = "src/projects/OOPExam/resources/data.csv";


    private CSVReader reader;
    private CSVWriter writer;
    private List<Employee> employees;

    public StaffService(CSVReader reader, CSVWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.employees = readData();
    }

    public List<Employee> readData() {
        return reader.readData(FILE_NAME);
    }

    @Override
    public void writeData() {
        writer.writeData(employees, FILE_NAME);
    }

    @Override
    public void editEmployee(int id, String[] data) {
        Employee employee = getEmployeeById(id);
        employee.setId(Integer.parseInt(data[0]));
        employee.setName(data[1]);
        employee.setDepartment(data[2]);
        employee.setRole(data[3]);
        employee.setSalary(Double.parseDouble(data[4]));
    }

    @Override
    public String fireEmployee(int id) {
        if (getEmployeeById(id) != null) {
            Employee employee = getEmployeeById(id);
            employee.setEndDate(LocalDate.now().toString());
            String employeeInfo = employee.toString();
            employees.remove(employee);
            return "You Fired " + employeeInfo;
        }
        return null;
    }

    @Override
    public void save() {
        writeData();
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public List<Employee> searchDepartmentByName(String departmentName) {
        return employees.stream().filter(e -> e.getDepartment().equals(departmentName))
                .collect(Collectors.toList());
    }

    @Override
    public String searchEmployeeByName(String name) {
        Employee employee = employees.stream().filter(e -> e.getName().equals(name)).findAny().orElseGet(null);
        return employee.toString();
    }

    @Override
    public String searchEmployeeById(int id) {
        return getEmployeeById(id).toString();
    }

    private Employee getEmployeeById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findAny().orElseGet(null);
    }
}
