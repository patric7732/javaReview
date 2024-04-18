package review.ioTest;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Exam01 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = "c:\\temp\\phone.txt";

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filePath))) {
            for (int i = 0; i < 3; i++) {
                System.out.print("이름: ");
                String name = reader.readLine();
                System.out.print("전화번호: ");
                String phoneNumber = reader.readLine();

                // Write to file
                writer.println(name + " " + phoneNumber);
            }

            System.out.println("... 전화번호가 " + filePath + "에 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("\n" + filePath + "의 내용은 다음과 같습니다...");
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
