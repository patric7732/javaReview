package review.threadTest;
import java.util.Random;

class IncrementCounter implements Runnable {
    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 1; i <= 100; i++) {
            System.out.println("Increment: " + i);
            try {
                Thread.sleep(rand.nextInt(11));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DecrementCounter implements Runnable {
    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 100; i >= 0; i--) {
            System.out.println("Decrement: " + i);
            try {
                Thread.sleep(rand.nextInt(11));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Exam01 {
    public static void main(String[] args) {
        Thread incrementThread = new Thread(new IncrementCounter());
        Thread decrementThread = new Thread(new DecrementCounter());

        incrementThread.start();
        decrementThread.start();
    }
}
