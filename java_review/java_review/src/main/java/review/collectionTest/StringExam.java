package review.collectionTest;

public class StringExam {
    public static void main(String[] args) {
        String greeting = "Hello, World ";
        System.out.println("문자열의 길이: " + greeting.length());
        System.out.println("5번째 문자: " + greeting.charAt(4));
        System.out.println("부분 문자열: " + greeting.substring(7, 12));

        System.out.println("_____________________");
        String str1 = "java";
        String str2 = "JAVA";

        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
    }
}
