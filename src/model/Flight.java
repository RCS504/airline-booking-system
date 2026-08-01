package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.enums.SeatStatus;

public class Flight {
    private String flightNumber;
    private Airport origin;
    private Airport destination;
    private Aircraft aircraft;
    private LocalDateTime departure;
    private double basePrice;
    private List<Seat> seats;

    public Flight(String flightNumber, Airport origin, Airport destination, Aircraft aircraft, LocalDateTime departure,
            double basePrice) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.aircraft = aircraft;
        this.departure = departure;
        this.basePrice = basePrice;
        this.seats = aircraft.generateSeatmap();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public double getBaseprice() {
        return basePrice;
    }

    public List<Seat> getSeat() {
        return seats;
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> s = new ArrayList<>();
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).getSeatStatus() == SeatStatus.AVAILABLE) {
                s.add(seats.get(i));
            }
        }
        return s;
    }

    @Override
    public String toString() {
        return (flightNumber + " (" + origin.getCode() + " ---> " + destination.getCode() + ") [" + departure + "] "
                + basePrice);
    }
}
