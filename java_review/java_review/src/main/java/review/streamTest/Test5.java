import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
public class Test5 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Smartphone", "Electronics", 700.00),
                new Product("Desk", "Furniture", 300.00),
                new Product("Chair", "Furniture", 150.00)
        );

        Map<String, Double> avg = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        avg.forEach((category, averagePrice) ->
                System.out.println(category + ": " + averagePrice));

    }
}
