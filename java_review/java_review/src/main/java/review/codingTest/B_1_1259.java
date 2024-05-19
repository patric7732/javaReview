import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (!(input = br.readLine()).equals("0")) {
            boolean isPal = true;
            int len = input.length();

            for (int i = 0; i < len / 2; i++) {
                if (input.charAt(i) != input.charAt(len - 1 - i)) {
                    isPal = false;
                    break;
                }
            }

            if (isPal) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
