package projects.OOPExam.services;

import projects.OOPExam.CSV.CSVReader;
import projects.OOPExam.CSV.CSVWriter;

public class StaffService implements Service {

    private CSVReader reader;
    private CSVWriter writer;

    public StaffService(CSVReader reader, CSVWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

}
