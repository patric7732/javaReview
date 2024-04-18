package review.exceptionTest;

import java.util.Scanner;

public class ExceptionExam06 {
    // 학생 점수를 입력 받는 메소드

    public void InputScore(int score){
    if(score<0 || score > 100){
//        System.out.println("score is upper 0 and down 100");
//        return;
        throw new MyException();
    }
        System.out.println(score);
    }

    public static void main(String[] args) {
        ExceptionExam06 exceptionExam07 = new ExceptionExam06();

        Scanner sc = new Scanner(System.in);

        System.out.println("Show your score");
        try {
            exceptionExam07.InputScore(sc.nextInt());
        } catch (MyException e) {
            System.out.println(e);
        }
        System.out.println("END Main");

    }
}
