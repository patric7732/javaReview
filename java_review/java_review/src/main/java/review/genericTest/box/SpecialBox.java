package review.genericTest.box;

public class SpecialBox<T> extends Box<T>{
    public SpecialBox(T content){
        super(content);
    }

    public void printContent(){
        System.out.println("Special box contains : " + getContent());
    }

    public static void main(String[] args) {
        SpecialBox<String> specialBox = new SpecialBox<>("스페셜 박스");
        System.out.println(specialBox);
    }
}
