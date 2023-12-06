package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Toothpaste;
import com.company.cosmetics.models.common.GenderType;


import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends ProductBase implements Toothpaste {
    private static final String ERROR_INGREDIENTS_MESSAGE = "Ingredients cannot be null.";
    private List<String> ingredients;
    public ToothpasteImpl(String name, String brand, double price, GenderType gender, List<String> ingredients) {
        super(name,brand,price,gender);
        setIngredients(ingredients);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public String getBrand() {
        return super.brand;
    }

    @Override
    public double getPrice() {
        return super.price;
    }

    @Override
    public GenderType getGender() {
        return super.gender;
    }

    @Override
    public String print() {
        return String.format("#Category: Toothpastes\n"+"%s"+" #Ingredients: %s\n"+" ===",super.print(),List.of(ingredients));
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>(this.ingredients);
    }
    private void setIngredients(List<String> ingredients) {
        if (ingredients == null) {
            throw new IllegalArgumentException(ERROR_INGREDIENTS_MESSAGE);
        }
        this.ingredients = new ArrayList<String>(ingredients);
    }
}
