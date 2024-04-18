package review.genericTest.box;

public class ColorBox <T, C> extends Box<T>{
    private C color;

    public ColorBox(T content, C color){
        super(content);
        this.color=color;
    }

    public C getColor() {
        return  color;
    }

    @Override
    public String toString() {
        return "Colored box with color " + color + " containing " + getContent();
    }

    public static void main(String[] args) {
        ColorBox<String, String> colorBox = new ColorBox("hi", "black");

        System.out.println(colorBox);

    }
}
