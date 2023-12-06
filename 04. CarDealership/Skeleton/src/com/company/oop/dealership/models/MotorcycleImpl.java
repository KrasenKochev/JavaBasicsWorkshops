package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Motorcycle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class MotorcycleImpl extends VehicleBase implements Motorcycle {

    private static final int CATEGORY_LEN_MIN = 3;
    private static final int CATEGORY_LEN_MAX = 10;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!",
            CATEGORY_LEN_MIN,
            CATEGORY_LEN_MAX);
    private String category;

    private final List<Comment> comments;
    private static final int WHEELS_NUMBER = 2;
    private final VehicleType type;
    public MotorcycleImpl(String make, String model, double price, String category) {
        super(make,model,price);
        setMake(make);
        setModel(model);
        setPrice(price);
        setCategory(category);
        this.type = VehicleType.MOTORCYCLE;
        comments = new ArrayList<>();
    }
    public String getCategory() {
        return category;
    }
    @Override
    public VehicleType getType() {
        return type;
    }
    @Override
    public int getWheels() {
        return WHEELS_NUMBER;
    }
    @Override
    public void addComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException();
        }
        comments.add(comment);
    }
    @Override
    public void removeComment(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException();
        }
        if (!comments.contains(comment)) {
            throw new IllegalArgumentException();
        }
        comments.remove(comment);
    }
    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }
    private void setCategory(String category) {
        ValidationHelpers.validateStringLength(category,CATEGORY_LEN_MIN,CATEGORY_LEN_MAX,CATEGORY_LEN_ERR);
        this.category = category;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Motorcycle:\n").append(super.toString()).append("Category: ").append(getCategory());

        StringBuilder builder = new StringBuilder();
        for (Comment value : comments) {
            builder.append(value);
        }
        String text = builder.toString();

        if (getComments().isEmpty()){
            result.append("\n--NO COMMENTS--");
        } else {
            result.append("\n--COMMENTS--\n").append(text).append("--COMMENTS--");
        }
        return result.toString();
    }
}
