package review;

public class ifTest {
    public static void main(String[] args) {
        int score = 70;

        if(score >= 90){
            System.out.println("A class");
        } else if (score >= 80) {
            System.out.println("B class");
        }  else if (score >= 70) {
            System.out.println("C class");
        }  else if (score >= 60) {
            System.out.println("D class");
        }  else if (score >= 50) {
            System.out.println("E class");
        } else {
            System.out.println(" FAIL ");
        }

        int result = (score>90) ? 100 : 50;
        System.out.println(result);

    }
}
