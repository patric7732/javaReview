import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S_2_12933 {

    // 여기서 quack의 순서를 비교해야할 때 어떻게 해야할까..?
    // q가 시작되었을때 시작이니, 고정적으로 하지 말고 uack를 순차적으로 순회해서 duck의 문자열과 똑같으면 출력


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] duckSound = br.readLine().toCharArray();
        int duckSoundLength = duckSound.length;

        // 입력된 사운드의 길이가 5의 배수인지 확인
        if (duckSoundLength % 5 != 0) {
            System.out.println(-1);
            return;
        }

        // 올바른 오리 소리를 나타내는 배열
        char[] duck = {'q', 'u', 'a', 'c', 'k'};

        int duckCount = 0;

        // 사운드를 순회하면서 오리 소리인지 확인
        for (int i = 0; i < duckSoundLength; i++) {
            // 현재 위치의 사운드가 오리 소리의 첫 번째 글자인 'q'인 경우 확인 시작
            if (duckSound[i] == 'q') {
                boolean isDuckSound = true; // 현재 위치부터 오리 소리인지 확인하는 변수

                // 현재 위치부터 5글자까지 오리 소리인지 확인
                for (int j = 0; j < 5; j++) {
                    // 현재 위치 + j 번째 글자가 오리 소리 배열과 다른 경우 오리 소리가 아님
                    if (i + j >= duckSoundLength || duckSound[i + j] != duck[j]) {
                        isDuckSound = false;
                        break;
                    }
                }

                // 현재 위치부터 5글자까지 오리 소리라면 오리의 수를 증가
                if (isDuckSound) {
                    duckCount++;
                }
            }
        }

        // 오리의 수 출력
        System.out.println(duckCount);
    }
}