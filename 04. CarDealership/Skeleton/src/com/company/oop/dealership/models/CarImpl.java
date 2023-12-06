package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Car;
import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class CarImpl extends VehicleBase implements Car {

    private static final int CAR_SEATS_MIN = 1;
    private static final int CAR_SEATS_MAX = 10;
    private static final String CAR_SEATS_ERR = format(
            "Seats must be between %d and %d!",
            CAR_SEATS_MIN,
            CAR_SEATS_MAX);
    private static final int WHEELS_NUMBER = 4;
    private int seats;
    private final VehicleType type;
    private final List<Comment> comments;
    public CarImpl(String make, String model, double price, int seats) {
        super(make,model,price);
        setMake(make);
        setModel(model);
        setPrice(price);
        setSeats(seats);
        this.type = VehicleType.CAR;
        comments = new ArrayList<>();
    }
    public int getSeats() {
        return seats;
    }
    @Override
    public VehicleType getType() {
        return type;
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
    private void setSeats(int seats) {
        ValidationHelpers.validateIntRange(seats,CAR_SEATS_MIN,CAR_SEATS_MAX,CAR_SEATS_ERR);
        this.seats = seats;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Car:\n").append(super.toString()).append("Seats: ").append(getSeats());

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
