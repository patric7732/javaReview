import java.util.Arrays;
import java.util.Scanner;

public class S_4_1920 {

    static int[] target;

    static int search(int value, int start, int end) {
        if (start > end) {
            return 0;
        }
        int mid = (start + end) / 2;
        if (target[mid] == value) {
            return 1;
        } else if (value < target[mid]) {
            return search(value, start, mid - 1);
        } else {
            return search(value, mid + 1, end);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        target = new int[n];
        for (int i=0; i<n; i++)
            target[i] = sc.nextInt();
        Arrays.sort(target);

        int m = sc.nextInt();
        for (int i=0; i<m; i++) {
            int value = sc.nextInt();

            System.out.println(search(value, 0, n-1));
        }
    }



}
