package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Shampoo;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.UsageType;


public class ShampooImpl extends ProductBase implements Shampoo {

    private static final String ERROR_USAGE_TYPE_MESSAGE = "Usage Type needs to be inputted";
    private static final int MIN_MILLILITERS = 0;
    private static final String ERROR_MILLILITERS_MESSAGE = "Milliliters need to be valid";
    private int milliliters;
    private UsageType everyDay;
    public ShampooImpl(String name, String brand, double price, GenderType gender, int milliliters, UsageType everyDay) {
        super(name,brand,price,gender);
        setMilliliters(milliliters);
        setEveryDay(everyDay);
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

    private void setEveryDay(UsageType everyDay) {
        if (everyDay==null){
            throw new IllegalArgumentException(ERROR_USAGE_TYPE_MESSAGE);
        }
        this.everyDay = everyDay;
    }

    @Override
    public String print() {
        return String.format("#Category: Shampoos\n"+"%s"+" #Milliliters: %d\n"+" #Usage: %s\n"+" ===",
            super.print(), getMilliliters(), getEveryDay());
    }
    @Override
    public int getMilliliters() {
        return milliliters;
    }
    private void setMilliliters(int milliliters) {
        if (milliliters< MIN_MILLILITERS){
            throw new IllegalArgumentException(ERROR_MILLILITERS_MESSAGE);
        }
        this.milliliters = milliliters;
    }

    public UsageType getEveryDay() {
        return everyDay;
    }
    @Override
    public UsageType getUsage() {
        return everyDay;
    }

}
