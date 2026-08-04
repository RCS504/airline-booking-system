package system;

import java.util.HashMap;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Flight;
import model.Aircraft;
import model.Airport;
import model.Booking;
import model.Seat;
import model.enums.BookingStatus;
import model.enums.SeatStatus;
import model.Passenger;

public class BookingSystem {
    private List<Flight> flights = new ArrayList<>();
    private HashMap<String, Booking> bookings = new HashMap<>();
    private List<Airport> airports = new ArrayList<>();
    private List<Aircraft> aircrafts = new ArrayList<>();

    public Aircraft getAircraftByModel(String aircraftModel) {
        for (int i = 0; i < aircrafts.size(); i++) {
            if (aircrafts.get(i).getModel().equals(aircraftModel)) {
                return aircrafts.get(i);
            }
        }
        return null;
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public Airport getAirportByCode(String airportCode) {
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getCode().equals(airportCode)) {
                return airports.get(i);
            }
        }
        return null;
    }

    public void addAirport(Airport airport) {
        airports.add(airport);
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> searchFlights(String origin, String destination, LocalDate date) {
        List<Flight> results = new ArrayList<>();
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getOrigin().getCode().equals(origin)
                    && flights.get(i).getDestination().getCode().equals(destination)
                    && flights.get(i).getDeparture().toLocalDate().isEqual(date)) {
                results.add(flights.get(i));
            }
        }
        return results;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public Flight getFlightByNumber(String number) {
        for (int i = 0; i < flights.size(); i++) {
            String flightNumber = flights.get(i).getFlightNumber();
            if (flightNumber.equals(number)) {
                return flights.get(i);
            }
        }
        return null;
    }

    public List<Seat> viewSeatMap(Flight flight) {
        return flight.getSeat();
    }

    public Booking bookSeat(Flight flight, Seat seat, Passenger passenger) {
        if (seat.getSeatStatus() != SeatStatus.AVAILABLE) {
            return null;
        }
        String ref;
        do {
            ref = "";
            Random r = new Random();
            String pool = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            for (int i = 0; i < 6; i++) {
                int randomInt = r.nextInt(pool.length());
                char c = pool.charAt(randomInt);
                ref = ref + c;
            }
        } while (bookings.containsKey(ref));
        seat.setSeatStatus(SeatStatus.BOOKED);
        Booking booking = new Booking(ref, passenger, flight, seat);
        bookings.put(ref, booking);
        return booking;
    }

    public Booking getBooking(String reference) {
        return bookings.get(reference);
    }

    public boolean cancelBooking(String reference) {
        if (bookings.containsKey(reference)) {
            Booking b = bookings.get(reference);
            if (b.getBookingStatus() != BookingStatus.CANCELLED) {
                b.setBookingStatus(BookingStatus.CANCELLED);
                b.getSeat().setSeatStatus(SeatStatus.AVAILABLE);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public List<Booking> getBookingsForFlight(Flight flight) {
        List<Booking> results = new ArrayList<>();
        for (Booking b : bookings.values()) {
            if (b.getFlight() == flight) {
                results.add(b);
            }
        }
        return results;
    }
}
