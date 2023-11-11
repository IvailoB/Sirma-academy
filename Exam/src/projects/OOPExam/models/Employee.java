package projects.OOPExam.models;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private String startDate;
    private String endDate;
    private String department;
    private String role;
    private double salary;

    public Employee(int id, String name, String startDate, String endDate, String department, String role, double salary) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return
                id + ',' + name + ',' + startDate + ',' + endDate + ',' + department + ',' + role + ',' + salary;
    }

    public Employee readEmployeeDataFromFile(String employeeDataFromFile) {
        String[] data = employeeDataFromFile.split(",");
        setId(Integer.parseInt(data[0]));
        setName(data[1]);
        setStartDate(data[2]);
        setEndDate(data[3]);
        setDepartment(data[4]);
        setRole(data[5]);
        setSalary(Double.parseDouble(data[6]));

        return this;
    }
}
