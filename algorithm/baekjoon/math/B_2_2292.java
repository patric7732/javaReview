
import java.util.Scanner;

public class B_2_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int count = 1;
        int room = 1;

        if(x==1){
            System.out.println(1);
        }else{
            while(x>=room){
                room += count*6;
                count++;
            }
            System.out.println(count);
        }
    }
}