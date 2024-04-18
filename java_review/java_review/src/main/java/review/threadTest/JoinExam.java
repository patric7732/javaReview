package review.threadTest;

public class JoinExam {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start(); //계산


        // sumThread가 끝날 때까지 메인은 실행이 안됨.
        try {
            sumThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("SumThread에서 계산한 결과는: ");
    }
}

class SumThread extends Thread {

    @Override
    public void run() {
        //계산 담당하는 쓰레드
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("계산 종료");
    }
}
