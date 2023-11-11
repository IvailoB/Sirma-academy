package projects.OOPExam.services;

import projects.OOPExam.CSV.CSVReader;
import projects.OOPExam.CSV.CSVWriter;
import projects.OOPExam.models.Employee;

import java.util.List;

public class StaffService implements Service {

    private static final String FILE_NAME = "src/projects/OOPExam/resources/data.csv";


    private CSVReader reader;
    private CSVWriter writer;

    public StaffService(CSVReader reader, CSVWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<Employee> readData(String FILE_NAME) {
        return reader.readData(FILE_NAME);
    }

    public void writeData(Employee employee) {
        List<Employee> oldContent = reader.readData(FILE_NAME);
        writer.writeData(employee, FILE_NAME, oldContent);
    }
}
