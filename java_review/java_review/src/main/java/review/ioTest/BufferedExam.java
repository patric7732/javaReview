package review.ioTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BufferedExam {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter("bufferedExam.txt");
        ) {
            System.out.println("문자열을 입력하세요.");

            for (int i = 0; i < 5; i++) {
                String str = br.readLine();
                pw.println(str);  // 이제 println 메서드를 사용할 수 있습니다.
            }
            pw.flush();  // 파일에 쓰기를 완료하기 위해 flush를 호출합니다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
