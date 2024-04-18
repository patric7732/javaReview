package review.collectionTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_3_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] att = new boolean[31];

        for (int i = 0; i<28; i++){
            int N = Integer.parseInt(br.readLine());
            att[N] = true;
        }

        for (int i = 1; i<=30; i++){
            if(!att[i]) {
                System.out.println(i);
            }
        }



    }
}
