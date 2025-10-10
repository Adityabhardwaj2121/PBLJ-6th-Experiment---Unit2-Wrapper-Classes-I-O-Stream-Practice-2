import java.util.*;
import java.util.stream.*;

class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return name + " | Category: " + category + " | Price: " + price;
    }
}

public class PartC {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 75000, "Electronics"),
            new Product("Phone", 50000, "Electronics"),
            new Product("T-shirt", 1500, "Clothing"),
            new Product("Jeans", 2000, "Clothing"),
            new Product("Washing Machine", 30000, "Home Appliance"),
            new Product("Refrigerator", 45000, "Home Appliance")
        );

        System.out.println("Products grouped by category:");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        grouped.forEach((cat, list) -> System.out.println(cat + ": " + list));

        System.out.println("\nMost expensive product in each category:");
        Map<String, Optional<Product>> maxPrice = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        maxPrice.forEach((cat, prod) ->
                System.out.println(cat + ": " + prod.get().name + " (₹" + prod.get().price + ")")
        );

        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage price of all products: ₹" + avgPrice);
    }
}
