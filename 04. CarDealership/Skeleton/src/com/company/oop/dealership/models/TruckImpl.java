package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Truck;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class TruckImpl extends VehicleBase implements Truck {

    private static final int WEIGHT_CAP_MIN = 1;
    private static final int WEIGHT_CAP_MAX = 100;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!",
            WEIGHT_CAP_MIN,
            WEIGHT_CAP_MAX);
    private final VehicleType type;
    private static final int WHEELS_NUMBER = 8;
    private int weightCapacity;
    private final List<Comment> comments;
    public TruckImpl(String make, String model, double price, int weightCapacity) {
        super(make,model,price);
        setMake(make);
        setModel(model);
        setPrice(price);
        setWeightCapacity(weightCapacity);
        this.type = VehicleType.TRUCK;
        comments = new ArrayList<>();
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }
    @Override
    public int getWheels() {
        return WHEELS_NUMBER;
    }
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
    private void setWeightCapacity(int weightCapacity) {
        ValidationHelpers.validateIntRange(weightCapacity,WEIGHT_CAP_MIN,WEIGHT_CAP_MAX,WEIGHT_CAP_ERR);
        this.weightCapacity = weightCapacity;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Truck:\n").append(super.toString()).append("Weight Capacity: ").append(getWeightCapacity()).append("t");
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
