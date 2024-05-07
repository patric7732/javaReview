import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < N ; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length() ; j++) {
                if(str.charAt(j) == '('){
                    stack.push(str.charAt(j));
                }else{
                    if(stack.isEmpty()){
                        stack.push(str.charAt(j));
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
