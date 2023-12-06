package com.company.oop.cosmetics.core.factories;

import com.company.oop.cosmetics.models.Category;
import com.company.oop.cosmetics.models.cart.ShoppingCart;
import com.company.oop.cosmetics.models.common.GenderType;
import com.company.oop.cosmetics.models.products.Product;
import com.company.oop.cosmetics.core.contracts.CosmeticsFactory;

import java.util.List;

public class CosmeticsFactoryImpl implements CosmeticsFactory {
    
    public Category createCategory(String name) {
        return new Category(name);
    }
    
    public Product createProduct(String name, String brand, double price, String gender) {
        if (name == null || brand == null || gender == null) {
            throw new IllegalArgumentException("Name, brand and gender should not be empty");}
        return new Product(name,brand,price, GenderType.valueOf(gender));

//        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public ShoppingCart createShoppingCart(List<Product> productList) {
        return new ShoppingCart();
    }
    
}
