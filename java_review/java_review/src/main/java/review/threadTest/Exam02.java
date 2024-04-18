package review.threadTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileReaderTask implements Runnable {
    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read from file: " + line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

class FileWriterTask implements Runnable {
    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            System.out.println("Enter text to write to the file (Type 'exit' to finish):");
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                writer.write(input + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

public class Exam02 {
    public static void main(String[] args) {
    Thread fileReaderTask = new Thread(new FileReaderTask());
    Thread fileWriterTask = new Thread(new FileWriterTask());

    fileReaderTask.start();
    fileWriterTask.start();
    }


}
