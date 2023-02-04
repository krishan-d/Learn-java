package com.learning.misc_advanced.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class LambdaExpressionExample3 {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1000, "PC", 20000));
        productList.add(new Product(2000, "iphone", 40000));
        productList.add(new Product(3000, "Nokia", 30000));

        Stream<Product> filteredData = productList.stream().filter(p -> p.price > 20000);
        //Iterate through collection
        filteredData.forEach(product -> System.out.println(product.name + ":" + product.price));
    }
}
