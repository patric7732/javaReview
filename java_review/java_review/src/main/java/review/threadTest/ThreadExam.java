package review.threadTest;

class MyThread extends Thread{ // 상속.. Thread를 상속받은 MyThread 는 Thread 이다.

    @Override
    public void run() {
        // 실제 쓰레드가 해야하는 일
        System.out.println("MY THREAD가 작동됩니다.");
        for (int i = 0; i< 10; i++){
            System.out.println("안녕하세요, MY THREAD의 FOR문입니다.");
        }
        System.out.println("MY THREAD가 종료되었습니다.");
    }
}

class OtherThread extends Thread{ // 상속.. Thread를 상속받은 MyThread 는 Thread 이다.

    @Override
    public void run() {
        // 실제 쓰레드가 해야하는 일
        System.out.println("OTHER THREAD가 작동됩니다.");
        for (int i = 0; i< 10; i++){
            System.out.println("안녕하세요, OTHER THREAD의 FOR문입니다.");
        }
        System.out.println("OTHER THREAD가 종료되었습니다.");
    }
}
public class ThreadExam {
    public static void main(String[] args) {
        System.out.println("MAIN이 작동됩니다.");

        //쓰레드 생성.
        MyThread myThread = new MyThread();
        myThread.start();
        OtherThread otherThread = new OtherThread();
        otherThread.start();

        for (int i = 0; i<10; i++){
            System.out.println("안녕하세요, MAIN의 FOR문입니다.");
        }

        System.out.println("MAIN이 종료되었습니다.");
    }


}
