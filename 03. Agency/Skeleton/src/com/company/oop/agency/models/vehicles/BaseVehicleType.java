package com.company.oop.agency.models.vehicles;
import com.company.oop.agency.utils.ValidationHelper;

public abstract class BaseVehicleType {
    protected int id;
    protected int passengerCapacity;
    protected double pricePerKilometer;
    protected VehicleType vehicleType;
    protected static final int PASSENGER_MIN_VALUE = 1;
    protected static final int PASSENGER_MAX_VALUE = 800;
    protected static final String PASSENGER_ERROR_MESSAGE = String.format("A train cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    protected static final double PRICE_MIN_VALUE = 0.1;
    protected static final double PRICE_MAX_VALUE = 2.5;
    protected static final String PRICE_ERROR_MESSAGE = String.format("A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!", PRICE_MIN_VALUE, PRICE_MAX_VALUE);
    protected BaseVehicleType(int id,int passengerCapacity, double pricePerKilometer, VehicleType vehicleType) {
        this.id=id;
        ValidationHelper.validateValueInRange(passengerCapacity,PASSENGER_MIN_VALUE,PASSENGER_MAX_VALUE,PASSENGER_ERROR_MESSAGE);

        this.passengerCapacity=passengerCapacity;
        ValidationHelper.validateValueInRange(pricePerKilometer,PRICE_MIN_VALUE,PRICE_MAX_VALUE,PRICE_ERROR_MESSAGE);

        this.pricePerKilometer=pricePerKilometer;
        this.vehicleType=vehicleType;
    }
    protected int getId(){return id;}
    protected int getPassengerCapacity(){return passengerCapacity;}
    protected double getPricePerKilometer() {
        return pricePerKilometer;
    }
    protected VehicleType getVehicleType() {
        return vehicleType;
    }

}
