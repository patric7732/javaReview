package review.collectionTest;

public class mathExam1 {
    public static int randomNum(){
        int number = (int) (Math.random() * 100); // 0 이상 100 미만의 double 값이 반환됨
        return number;
    }

    public static void main(String[] args) {
        System.out.println(randomNum());
    }

}
