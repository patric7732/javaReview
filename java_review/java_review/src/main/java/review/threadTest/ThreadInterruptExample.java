package review.threadTest;

public class ThreadInterruptExample {
    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.println("프로세싱 단계 " + (i + 1));
                }
            } catch (InterruptedException e) {
                System.out.println("스레드 중단");
                return;
            }
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();

        try{
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();
    }
}
