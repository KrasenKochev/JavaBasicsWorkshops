package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Cream;
import com.company.cosmetics.models.common.GenderType;
import com.company.cosmetics.models.common.ScentType;

import java.util.List;


public class CreamImpl extends ProductBase implements Cream {
    private static final String ERROR_SCENT_MESSAGE = "Please input a proper scent";
    private ScentType scent;
    public CreamImpl(String name, String brand, double price, GenderType gender, ScentType scent) {
        super(name, brand, price, gender);
        setScent(scent);
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
    public ScentType getScent() {
        return scent;
    }
    private void setScent(ScentType scent) {
        if (scent == null) {
            throw new IllegalArgumentException(ERROR_SCENT_MESSAGE);
        }
        this.scent = scent;
    }
    @Override
    public String print() {
        return String.format("#Category: Creams\n"+"%s"+" #Scent: %s\n"+" ===",super.print(), scent);
    }
}
