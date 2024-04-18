package review.exceptionTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int O = Integer.parseInt(st.nextToken());
                sb.append(O).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}