package sample.bean;

public class Book {
    private String title;
    private int price;

    public Book(String title, int price) {
        System.out.println("생성자 생성");
        this.title = title;
        this.price = price;

    }

    public String getTitle() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SpringExam02{" +
                "name='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
