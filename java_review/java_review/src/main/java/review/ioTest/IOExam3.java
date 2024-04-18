package review.ioTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class IOExam3 {
    public static void main(String[] args) {
        String inputFileName = "test.txt";
        String outputFileName = "testhi.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             PrintWriter pw = new PrintWriter(outputFileName)) {

            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line + "hi");  // 읽은 라인에 "hi"를 추가하여 출력
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
