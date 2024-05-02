import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S_4_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        int result = 0;

        // sum으로 시간 구간마다의 합을 출력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++){
            int M = Integer.parseInt(st.nextToken());
            arr.add(M);
        }

        Collections.sort(arr);

        for (int i = 0; i < N; i++) {
            sum += arr.get(i) * (N - i);
        }

        result += sum;

        System.out.println(result);
    }
}

