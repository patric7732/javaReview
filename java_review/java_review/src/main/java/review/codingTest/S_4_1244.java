import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.naming.PartialResultException;

public class S_4_1244 {
    public static void main(String[] args) throws IOException {
        // 0 1 1 1 0 1 0 1 일때 여학생이 3을 받았다면?
        // 1 0 0 0 1 1 0 1
        // 3인 1을 기준으로 양쪽의 스위치 상태를 확인한 후 스위치를 바꾼다.
        // 남학생은 뭐임?
        // 0 1 0 1 0 0 0 1일떄 남학생이 3을 받으면, 그 숫자의 배수와 자신의 상태를 바꿈
        // 0 1 1 1 0 1 0 1
        // 그럼 0 1 0 1 0 0 0 1 일때 남학생이 3을 받고, 여학생이 3을 받으면?
        //     0 1 1 1 0 1 0 1
        //     1 0 0 0 1 1 0 1

        // 그러면 케이스문?을 이용해볼까?
        // 먼저 스위치의 개수를 입력 받고 스위치 배열에 그 숫자만큼 값을 넣는다.
        //

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

                // 범위를 지정해준뒤 스위치의 지정 숫자의
                // 양쪽 값을 비교하여 같다면 스위치를 바꾸고 아니면 break

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

// 0 1 1 1 0 1 0 1
    }
}
