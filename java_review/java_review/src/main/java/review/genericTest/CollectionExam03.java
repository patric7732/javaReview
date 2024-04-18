package review.genericTest;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CollectionExam03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> scores = new ArrayList<>();

        readScores(input, scores);
        removeZero(scores);
        printScores(scores);

        input.close();
    }

    public static void readScores(Scanner input, List<Integer> scores){
        while (true) {
            System.out.println("점수를 입력하세요, 0을 입력하면 종료됩니다.");
            try{
            int score = input.nextInt();

            if(score == 0) {
                scores.add(score);
                break;
            }

            if(score<0 || score > 100) {
                throw new InputMismatchException();
            }

            scores.add(score);

            } catch(InputMismatchException e) {
                System.out.println(e.toString());
                System.out.println("0~100 사이의 숫자만 입력 가능합니다.");
                input.nextLine();
            }
        }

    }

    public static void removeZero(List<Integer> scores){
        if(scores.get(scores.size() - 1)== 0){
            scores.remove(scores.size() - 1);
        }
    }

    public static void printScores(List<Integer>scores){
        int sum = 0;
        for (int score : scores) {
            System.out.println(score);
            sum += score;
        };

        System.out.println("총 점수 : " + sum);
        System.out.println("평균 점수 : " + sum / scores.size());
    }
}