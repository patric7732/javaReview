package review.ioTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exam03 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0 && !arr.isEmpty()) {
                arr.remove(arr.size() - 1);
            } else if (number != 0) {
                arr.add(number);
            }
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        System.out.println(sum);
    }
}
