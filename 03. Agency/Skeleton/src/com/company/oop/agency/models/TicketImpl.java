package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    private static final double COST_MIN_PRICE = 0.0;
    private int id;
    private Journey journey;
    private double costs;
    public TicketImpl(int id, Journey journey, double costs) {
        setId(id);
        setJourney(journey);
        setCosts(costs);
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    public double getCosts() {
        return costs;
    }
    @Override
    public double calculatePrice() {
        return getAdministrativeCosts() * journey.calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return costs;
    }

    @Override
    public String getAsString() {
        return String.format("Ticket ----\n" +
                "Destination: %s\n" +
                "Price: %.2f\n",
                journey.getDestination(),
                calculatePrice());
    }

    private void setId(int id) {
        this.id = id;
    }
    private void setJourney(Journey journey) {
        if (journey==null){
            throw new IllegalArgumentException();
        }
        this.journey = journey;
    }
    private void setCosts(double costs) {
        if (costs< COST_MIN_PRICE){
            throw new InvalidUserInputException(String.format("Value of 'costs' must be a positive number. Actual value: %.2f.",costs));
        }
        this.costs = costs;
    }
}
