package review.genericTest;

public class GenericMethodExample2 {
    public static <T extends Number> T max(T x, T y, T z) {
        T max = x;

        if (y.doubleValue() > max.doubleValue()) {
            max = y;
        }
        if (z.doubleValue() > max.doubleValue()){
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("최댓값 " + max(3,4,5));
        System.out.println("최댓값 " + max(6.4,2,1.8));
        System.out.println("최댓값 " + max(9,2.3,2.5));


    }
}
