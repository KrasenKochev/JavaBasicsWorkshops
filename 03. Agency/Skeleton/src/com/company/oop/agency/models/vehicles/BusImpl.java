package com.company.oop.agency.models.vehicles;
import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends BaseVehicleType implements Bus {
    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    private static final String VEHICLE_ERROR_MESSAGE = "The vehicle type must be viable";
    private static final String PASSENGER_ERROR_MESSAGE = String.format("A train cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE);
    private static final String PRICE_ERROR_MESSAGE = String.format("A train  price cannot be less than %f or more than %f.", PRICE_MIN_VALUE, PRICE_MAX_VALUE);
    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id,passengerCapacity,pricePerKilometer,VehicleType.LAND);
        setId(id);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
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
    public VehicleType getType() {
        return vehicleType;
    }
    @Override
    public String getAsString() {
        return String.format("Bus ----\n" +
                "Passenger capacity: %d\n" +
                "Price per kilometer: %.2f\n" +
                "Vehicle type: %s\n",
                passengerCapacity,
                pricePerKilometer,
                vehicleType);
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
    private void setVehicleType(VehicleType vehicleType) {
        if (vehicleType==null){
            throw new IllegalArgumentException(VEHICLE_ERROR_MESSAGE);
        }
        this.vehicleType=vehicleType;
    }
    private void setId(int id) {
        this.id = id;
    }

}