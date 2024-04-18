package review.collectionTest;

public class EventProcessor {
    public void processEvent(String event) {
        class EventHandler{
            public void handle(){
                System.out.println("처리중인 이벤트: " + event);
            }
        }

        EventHandler handler = new EventHandler();
        handler.handle();
    }

    public static void main(String[] args) {
        EventProcessor eventProcessor = new EventProcessor();
        eventProcessor.processEvent("핵 검거");
    }
}
