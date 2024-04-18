package review.ioTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIOExample {
    public static void main(String[] args) {
        // 키보드 (System.in)로부터 한 줄 입력 받기위한 IO객체 생성., InputStream... 중간 매개체 역할.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("문자열 입력: ");
            String userInput = br.readLine();

            System.out.println("입력받은 문자열: " + userInput);
        } catch (IOException e) {
            System.out.println("입력 오류가 발생했습니다. : " + e.getMessage());
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("리더를 닫는 중 오류가 발생 : " + e.getMessage());
            }
        }
    }
}
