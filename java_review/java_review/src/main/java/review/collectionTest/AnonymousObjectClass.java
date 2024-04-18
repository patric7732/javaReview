package review.collectionTest;

public class AnonymousObjectClass {
    private int outerField = 10;

    public void outerMethod(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("outer Field : " + outerField);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.outerMethod();
    }
}
