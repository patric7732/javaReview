package review.collectionTest;

public class Network {
    private static int totalMessages = 0;

    public static class Message {
        private String content;

        public Message(String content) {
            this.content = content;
            totalMessages++;
        }

        public void send() {
            System.out.println("메세지 전송: " + content);
            System.out.println("전체 메시지 수: " + totalMessages);
        }

        public static int getTotalMessages() {
            return totalMessages;
        }

        public static void main(String[] args) {
            Message msg1 = new Message("안녕하세요!");
            Message msg2 = new Message("반갑습니다!");
            msg1.send();
            msg2.send();
// 출력 예시:
// 메시지 전송: 안녕하세요!
// 전체 메시지 수: 1
// 메시지 전송: 반갑습니다!
// 전체 메시지 수: 2
// 네트워크를 통해 전송된 전체 메시지 수: 2
        }
    }
}
