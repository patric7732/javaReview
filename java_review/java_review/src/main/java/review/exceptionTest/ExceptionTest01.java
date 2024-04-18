package review.exceptionTest;

import java.util.Scanner;

public class ExceptionTest01 {
    public static void checkNumber(int n){ // checkNumber를 static으로 변경
        if(n < 1 || n > 100){
            throw new IllegalArgumentException("숫자는 0과 100 안에 있어야 합니다. " + n);
        }
        System.out.println("입력한 숫자가 범위 내에 있습니다.");
    }

    public static void main(String[] args) {

        System.out.println("범위 내의 숫자를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        try {
            int number = sc.nextInt(); // 사용자로부터 숫자를 입력받음
            checkNumber(number); // 수정된 checkNumber 호출
        } catch (IllegalArgumentException e){ // IllegalArgumentException 처리
            System.out.println(e.getMessage());
        }
    }
}