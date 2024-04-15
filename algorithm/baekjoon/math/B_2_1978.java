import java.util.Scanner;

public class B_2_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int b = 0;

        for (int i=0; i<c; i++){
            int a = sc.nextInt();
            if (a==1){
                b += 0;
                continue;
            }
            int y = 0;
            for(int j=2; j<a; j++){
                if(a%j == 0){
                    y++;
                }
            }
            if (y == 0){
                b++;
            }
        }

        System.out.println(b);
    }
}
