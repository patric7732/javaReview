package review;

public class generateItem {
    int price;
    String name;

    public generateItem(int price, String name){
        this.price = price;
        this.name = name;
    }

    public int getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }

    public static void main(String[] args) {
        generateItem[] item = new generateItem[3];

        item[0] = new generateItem(1,"apple");
        item[1] = new generateItem(2,"peach");
        item[2] = new generateItem(3,"banana");

        System.out.println(item[0].getPrice());
        System.out.println(item[0].getName());

        System.out.println(item[1].getPrice());
        System.out.println(item[1].getName());

        System.out.println(item[2].getPrice());
        System.out.println(item[2].getName());

    }
}
