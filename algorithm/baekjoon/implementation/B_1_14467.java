import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1_14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[11][1];
        int cnt = 0;

        for(int i = 1; i < 11; i++){
            arr[i][0] = -1;
        }

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int cow = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());

            if(arr[cow][0] == -1){
                arr[cow][0] = road;
            }else{
                if(arr[cow][0] != road){
                    cnt++;
                    arr[cow][0] = road;
                }
            }
        }
        System.out.println(cnt);
    }
}
