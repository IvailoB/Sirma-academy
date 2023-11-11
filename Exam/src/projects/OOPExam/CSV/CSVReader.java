package projects.OOPExam.CSV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    //TODO create file path
    private static final String FILE_NAME = "src/projects/OOPExam/resources/data.csv";

    public List<String[]> readData(String FILE_NAME) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}


