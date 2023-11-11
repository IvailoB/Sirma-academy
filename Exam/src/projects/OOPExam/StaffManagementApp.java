package projects.OOPExam;

import projects.OOPExam.CSV.CSVReader;
import projects.OOPExam.CSV.CSVWriter;
import projects.OOPExam.models.Manager;
import projects.OOPExam.models.StaffManager;
import projects.OOPExam.services.Service;
import projects.OOPExam.services.StaffService;

import java.util.Scanner;

public class StaffManagementApp {

    public static void main(String[] args) {

        // implement fileReader/fileWriter to handle saving into csv/json

        CSVReader reader = new CSVReader();
        CSVWriter writer = new CSVWriter();
        Service service = new StaffService(reader, writer);
        Manager manager = new StaffManager(service);
        System.out.println(" & quot; Welcome to Staff Management System & quot;");
        boolean isRunning = true;
        while (isRunning) {
            displayCommands();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your command: ");
            String command = scanner.nextLine();
            manager.execute(command);

            // Add Employee
            // 1, Peter Peterson, IT, Junior Java Developer, 1400.50
            // Add Employee
            // 2, Ivan Ivanson, IT, Junior Front-End Developer, 1400.00
            // Edit 1
            // 1, Peter Peterson, IT, Java Developer, 2500.00
            // List employees
            // Search Department Marketing
            // Search Id 1
            // Fire 1
            // Search Name Peter
            // Save &amp; Exit
        }
    }

    private static void displayCommands() {
        System.out.println("Available Commands:");
        System.out.println("1. Add Employee");
        System.out.println("2. Edit Employee");
        System.out.println("3. Fire Employee");
        System.out.println("4. List Employees");
        System.out.println("5. Search Department [Department Name]");
        System.out.println("6. Search Id [Employee ID]");
        System.out.println("7. Search Name [Employee Name]");
        System.out.println("8. Save & Exit");
    }
}
