public class FinalVarialbleExam {
    public static void main(String[] args) {
        final int x = 10;
        System.out.println("람다에서 파이널로 사용");

        Runnable r = () -> {
            System.out.println("x : " + x);
        };
        r.run();
    }
}
