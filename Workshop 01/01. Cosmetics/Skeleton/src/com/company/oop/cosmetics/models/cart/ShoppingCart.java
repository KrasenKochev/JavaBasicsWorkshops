package com.company.oop.cosmetics.models.cart;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    
    private List<Product> productList;
    
    public ShoppingCart() {
        productList = new ArrayList<Product>();
    }
    
    public List<Product> getProductList() {
        return new ArrayList<>(productList);
    }
    
    public void addProduct(Product product) {
        this.productList.add(product);
//        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public void removeProduct(Product product) {
        this.productList.remove(product);
//        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public boolean containsProduct(Product product) {
        boolean isContained=false;
        if (productList.contains(product)){
            isContained=true;
        }
//        throw new UnsupportedOperationException("Not implemented yet.");
        return isContained;
    }
    
    public double totalPrice() {
        double totalPrice = 0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
            totalPrice = Math.round(totalPrice * 100.0) / 100.0;
        }
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
