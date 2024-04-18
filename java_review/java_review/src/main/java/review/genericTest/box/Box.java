package review.genericTest.box;

public class Box <T>{
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "box content: "+ content;
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>("hibox");
        System.out.println(stringBox);
    }
}
