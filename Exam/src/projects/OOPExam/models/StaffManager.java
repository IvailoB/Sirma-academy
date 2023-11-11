package projects.OOPExam.models;

import projects.OOPExam.services.Service;

public class StaffManager implements Manager {
    private Service service;

    public StaffManager(Service service) {
        this.service = service;
    }


    @Override
    public void execute(String command) {
        switch (command){
            case "Add Employee":
                addEmployee();
                break;
            case "Edit 1":
                editEmployee(id);
                break;
            case "List employees":
                listEmployees();
                break;
            case "Search Department Marketing":
                break;
            case "Search Id 1":
                searchEmployee(id);
                break;
            case "Fire 1":
                fireEmployee(id);
                break;
            case "Search Name []]":
                searchEmployeeByName(name);
                break;
            case "Save & Exit":
                save();
                break;
            default:
                System.out.println("Invalid command!");
                System.out.println("Please check and try again");
        }
    }
}
