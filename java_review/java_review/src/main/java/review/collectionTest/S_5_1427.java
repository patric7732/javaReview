package review.collectionTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S_5_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> results = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < M; j++) {
                int O = Integer.parseInt(st.nextToken());
                if (O < min) {
                    min = O;
                }
                if (O > max) {
                    max = O;
                }
            }

            results.add(min + " " + max);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}
