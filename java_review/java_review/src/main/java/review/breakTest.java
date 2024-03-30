package review;

public class breakTest {
    public static void main(String[] args) {
        outter:
        for (int i = 0; i<10; i++){
            for (int k = 0; k <3; k++){
                if (i == 3 && k == 2)
//                    break outter;
                    continue outter;
                System.out.println(i + "," + k);
            }
        }
    }
}
