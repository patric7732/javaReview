import java.util.Arrays;
import java.util.Scanner;

public class S_5_1427 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] count = sc.nextLine().toCharArray();

        Arrays.sort(count);

        for (int i = count.length-1; i >= 0; i--){
            System.out.println(count[i]);
        }
    }
}