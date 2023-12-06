package com.company.cosmetics.models.products;

import com.company.cosmetics.commands.ShowCategory;
import com.company.cosmetics.models.CategoryImpl;
import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;
import jdk.jfr.Category;

import java.util.Locale;


public class ProductBase implements Product {
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 10;
    private static final String ERROR_NAME_MESSAGE = String.format("Name needs to be from %d to %d letters in length", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
    private static final String ERROR_NO_NAME_MESSAGE = "Please input a name";
    private static final String ERROR_NO_BRAND_MESSAGE = "Please input a brand";
    private static final int MIN_BRAND_LENGTH = 2;
    private static final int MAX_BRAND_LENGTH = 10;
    private static final String ERROR_BRAND_MESSAGE = String.format("Brand name needs to be from %d to %d letters in length", MIN_BRAND_LENGTH, MAX_BRAND_LENGTH);
    private static final double MINIMUM_PRICE = 0.00;
    private static final String ERROR_PRICE_MESSAGE = "Please input a proper price";
    private static final String ERROR_GENDER_MESSAGE = "Please input a proper gender";

    protected String name;
    protected String brand;
    protected double price;
    protected GenderType gender;

    //Finish the class
    //What variables, what constants should you write here?
    //validate
    ProductBase(String name,String brand,double price,GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    @Override
    public String getName() {
        return name;
    }
    protected void setName(String name) {
        if (name==null){
            throw new IllegalArgumentException(ERROR_NO_NAME_MESSAGE);
        }
        if (name.length()< MIN_NAME_LENGTH ||name.length()> ProductBase.MAX_NAME_LENGTH){
            throw new IllegalArgumentException(ERROR_NAME_MESSAGE);
        }
        this.name = name;
    }
    @Override
    public String getBrand() {
        return brand;
    }
    protected void setBrand(String brand) {
        if (brand==null){
            throw new IllegalArgumentException(ERROR_NO_BRAND_MESSAGE);
        }
        if (brand.length()< MIN_BRAND_LENGTH ||brand.length()> MAX_BRAND_LENGTH){
            throw new IllegalArgumentException(ERROR_BRAND_MESSAGE);
        }
        this.brand = brand;
    }
    @Override
    public double getPrice() {
        return price;
    }
    protected void setPrice(double price) {
        if (price< MINIMUM_PRICE){
            throw new IllegalArgumentException(ERROR_PRICE_MESSAGE);
        }
        this.price = price;
    }
    @Override
    public GenderType getGender() {
        return gender;
    }
    protected void setGender(GenderType gender) {
        if (gender==null){
            throw new IllegalArgumentException(ERROR_GENDER_MESSAGE);
        }
        this.gender = gender;
    }
    @Override
    public String print() {
      return String.format(
              "#%s " + "%s\n" +" #Price: $%.2f\n" + " #Gender: %s\n",name,brand,price,gender);
    }
}
