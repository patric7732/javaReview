package review.threadTest;

public class ExampleThread extends Thread {
    @Override
    public void run() {
        System.out.println("쓰레드 시작");
        for (int i = 0; i < 4; i++) {
            System.out.println("스레드 동작 중");
        }
        System.out.println("쓰레드 끝");
    }

    public static void main(String[] args) {
        System.out.println("=================메인=============");
        ExampleThread exampleThread = new ExampleThread();
        exampleThread.start();
        System.out.println("=================메인 끝=============");
    }
}
