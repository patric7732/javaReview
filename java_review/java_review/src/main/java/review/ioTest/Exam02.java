package review.ioTest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


// 파일 쓰기와 읽기 작업
// 파일 IO작업 캡슐화
// 메소드 1. 파일 쓰기
// 메소드 2. 파일 읽기
class TextFileManager {
    private String filePath;

    public TextFileManager(String filePath) {
        this.filePath = filePath;
    }

    // 파일 쓰기
    public void writeToFile(List<String> userInput) throws IOException {
        try (PrintWriter pw = new PrintWriter(filePath)) {
            for (String line : userInput) {
                pw.println(line);
            }
        }
    }

    // 파일 읽기
    public List<String> readFromFile() throws IOException {
        List<String> fileContent = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.add(line);
            }
        }
        return fileContent;
    }
}

// 사용자로부터 입력 처리
// 메소드 1. 문자열을 입력받고 리스트로 반환
class UserInputHandler {
    // 사용자로부터 여러 줄의 입력을 받아 리스트로 반환
    public List<String> getUserInput() throws IOException {
        List<String> userInput = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("텍스트를 입력하세요, exit를 입력할시 프로그램을 종료합니다.");
            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                userInput.add(line);
            }
        }
        return userInput;
    }
}

// 애플리케이션의 주 실행 로직
public class Exam02 {
    public static void main(String[] args) {
        String filePath = "texts.txt";
        TextFileManager fileManager = new TextFileManager(filePath);
        UserInputHandler inputHandler = new UserInputHandler();

        try {
            List<String> userInput = inputHandler.getUserInput();
            fileManager.writeToFile(userInput);

            List<String> fileContent = fileManager.readFromFile();
            System.out.println("Content of the file:");
            fileContent.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
