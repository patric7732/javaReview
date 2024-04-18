package review.genericTest;

public class Box <T>{
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>("자바의 정석");
        String value = stringBox.getValue();

        Box<Integer> integerBox = new Box<>(123);
        Integer value1 = integerBox.getValue();

        System.out.println(value + value1);
    }
}
