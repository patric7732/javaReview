import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.naming.PartialResultException;

public class S_4_1244 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int stu = Integer.parseInt(br.readLine());
        for (int i = 0; i < stu; i++) {
            st = new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gen == 1) {
                for (int j = num-1; j < n; j+=num) {
                    if (switches[j] == 1) {
                        switches[j] = 0;
                    } else {
                        switches[j] = 1;
                    }
                }
            } else {
                int left = num - 2;
                int right = num;
                while (left > 0 && right < n) {
                    if (switches[left] != switches[right]) {
                        break;
                    }
                    left--;
                    right++;
                }

                for (int j = left; j <= right; j++) {
                    if (switches[j] == 1) {
                        switches[j] = 0;
                    } else {
                        switches[j] = 1;
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(switches[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
