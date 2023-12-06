package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {
    
    private String name;
    private List<Product> products;
    
    public Category(String name) {
        if (name.length() < 2 || name.length() > 15) {
            throw new IllegalArgumentException("Category name must be between 2 and 15 characters.");
        }
        this.name = name;
        this.products = new ArrayList<>();
    }
    
    public List<Product> getProducts() {

        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        products.add(product);
//        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public void removeProduct(Product product) {
        if (!products.remove(product)) {
            throw new IllegalArgumentException("Product not found in the category.");
        }
    }

    public String print () {
        String printResult = "#Category: " + name + "\n";
        if (products.isEmpty()) {
            printResult += " #No product in this category";
        } else {
            for (Product product : products) {
                printResult += " #" + product.getName() + " " + product.getBrand() + "\n";
                printResult += " #Price: " + product.getPrice() + "\n";
                printResult += " #Gender: " + product.getGender() + "\n";
                printResult += " ===\n";
            }
        }
        return printResult;
    }

}
