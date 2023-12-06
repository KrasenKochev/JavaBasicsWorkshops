package com.company.oop.cosmetics.models.products;

import com.company.oop.cosmetics.models.common.GenderType;

public class Product {
    private double price;
    private String name;
    private String brand;
    private GenderType gender;

    public Product(String name, String brand, double price, GenderType gender) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.gender = gender;
        // finish the constructor and validate data
        //    setPrice(price);
    }

    public Product(String name){
        this.name=name;
    }
    public String print() {
        String result = "";
        result = String.format(" #[%s] [%s]%n#Price: [%f]%n#Gender: [%s]%n===", name, brand, price, gender);

        return result;
        // Format:
        //" #[Name] [Brand]
        // #Price: [Price]
        // #Gender: [Gender]
        // ==="
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price<0) {
            throw new IllegalArgumentException("Price needs to be a positive number");
        }
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()<3||name.length()>10){
            throw new IllegalArgumentException("Name must be with a length of at least 3 and 10 characters");
        }
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand.length() < 2 || brand.length() > 10) {
            throw new IllegalArgumentException("Brand name must be with a length of at least 2 and 10 characters");
        }
        this.brand = brand;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        if (gender!=GenderType.MEN && gender!=GenderType.WOMAN && gender!=GenderType.UNISEX){
        throw new IllegalArgumentException("Gender needs to be Men, Women or Unisex");
        }
        this.gender = gender;
    }
}


