package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends BaseVehicleType implements Train {

    private static final int PASSENGER_MIN_VALUE = 30;
    private static final int PASSENGER_MAX_VALUE = 150;
    private static final String PASSENGER_ERROR_MESSAGE = String.format("A train cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    private static final int CARTS_MIN_VALUE = 1;
    private static final int CARTS_MAX_VALUE = 15;
    private static final String CARTS_ERROR_MESSAGE = String.format("A train cannot have less than %d cart or more than %d carts.", CARTS_MIN_VALUE, CARTS_MAX_VALUE);
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    private static final String PRICE_ERROR_MESSAGE = String.format("A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!", PRICE_MIN_VALUE, PRICE_MAX_VALUE);
    private static final String VEHICLE_ERROR_MESSAGE = "The vehicle type must be viable";
    private int carts;
    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id,passengerCapacity,pricePerKilometer,VehicleType.LAND);
        setId(id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
        setCarts(carts);
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }
    @Override
    public int getCarts() {
        return carts;
    }
    @Override
    public VehicleType getType() {
        return vehicleType;
    }
    @Override
    public String getAsString() {
        return String.format("Train ----\n" +
                "Passenger capacity: %d\n" +
                "Price per kilometer: %.2f\n" +
                "Vehicle type: %s\n" +
                "Carts amount: %d\n",
                passengerCapacity,
                pricePerKilometer,
                vehicleType,
                carts);
    }

    private void setPassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(
                passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                PASSENGER_ERROR_MESSAGE);
        this.passengerCapacity=passengerCapacity;
    }
    private void setPricePerKilometer(double pricePerKilometer) {
        ValidationHelper.validateValueInRange(
                pricePerKilometer,
                PRICE_MIN_VALUE,
                PRICE_MAX_VALUE,
                PRICE_ERROR_MESSAGE);
        this.pricePerKilometer=pricePerKilometer;
    }

    private void setCarts(int carts) {
        ValidationHelper.validateValueInRange(
                carts,
                CARTS_MIN_VALUE,
                CARTS_MAX_VALUE,
                CARTS_ERROR_MESSAGE);
        this.carts = carts;
    }
    private void setId(int id) {
        this.id = id;
    }
    private void setVehicleType(VehicleType vehicleType) {
        if (vehicleType==null){
            throw new IllegalArgumentException(VEHICLE_ERROR_MESSAGE);
        }
        this.vehicleType=vehicleType;
    }
}