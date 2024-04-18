package review.genericTest;

public class GenericMethodExample {
    public static <T> void printArrayElements(T[] array){
        for (T element : array){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] iarry = {1,2,3,4,5};
        printArrayElements(iarry);

        String[] strArray = {"hi", "hello", "kang"};
        printArrayElements(strArray);
    }
}
