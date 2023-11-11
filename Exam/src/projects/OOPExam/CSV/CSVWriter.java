package projects.OOPExam.CSV;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

    //TODO create file path
    private static final String FILE_NAME = "src/projects/OOPExam/resources/data.csv";

    public void writeData(List<String[]> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String[] values : data) {
                String line = String.join(",", values);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
