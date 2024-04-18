package review.threadTest;

// Runnable은 Run이라는 메소드가 가지고 있음
class MyRunnable implements Runnable { // MyRunnable 은 Thread는 아니다.
    @Override
    public void run() {
        // 실제 쓰레드가 해야하는 일
        System.out.println("MY RUNNABLE가 작동됩니다.");
        for (int i = 0; i < 10; i++) {
            System.out.println("안녕하세요, MY RUNNABLE의 FOR문입니다.");
        }
        System.out.println("MY RUNNABLE가 종료되었습니다.");
    }
}

class PatricRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("PATRIC RUNNABLE가 작동됩니다.");
        for (int i = 0; i < 10; i++) {
            System.out.println("안녕하세요, PATRIC RUNNABLE의 FOR문입니다.");
        }
        System.out.println("PATRIC RUNNABLE가 종료되었습니다.");
    }
}

class PatricThread extends Thread {
    @Override
    public void run() {
        System.out.println("PATRIC THREAD 작동됩니다.");
        for (int i = 0; i < 10; i++) {
            System.out.println("안녕하세요, PATRIC THREAD FOR문입니다.");
        }
        System.out.println("PATRIC THREAD 종료되었습니다.");
    }
}

public class RunnableExam {
    public static void main(String[] args) {
        System.out.println("MAIN이 작동됩니다.");

        //쓰레드 생성.
        // 쓰레드는 Runnable을 받을 수 있음.
        Thread myThread = new Thread(new MyRunnable());
        myThread.start();

        Thread otherThread = new Thread(new PatricRunnable());
        otherThread.start();

        PatricThread patricThread = new PatricThread();
        patricThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("안녕하세요, MAIN의 FOR문입니다.");
        }

        System.out.println("MAIN이 종료되었습니다.");
    }
}
