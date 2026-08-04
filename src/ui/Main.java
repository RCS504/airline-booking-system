package ui;

import system.BookingSystem;
import model.Aircraft;
import model.Airport;
import model.Booking;
import model.Flight;
import model.Passenger;
import model.Seat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        seedData(bookingSystem);
        Scanner input = new Scanner(System.in);

        int choice = 0;
        while (choice != 9) {
            System.out.printf(
                    "1.View Routes\n2.Search Flights\n3.View Seat Map\n4.Book Seat\n5.Cancel Booking\n6.Lookup Booking\n7.View All Bookings\n8.Add Flight\n9.Exit\nPlease choose an option from 1-9:");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("View Routes");
                    viewRoutes(bookingSystem);
                    break;
                case 2:
                    System.out.println("Search Flights");
                    searchFlight(bookingSystem, input);
                    break;
                case 3:
                    System.out.println("View Seat Map");
                    seatMap(bookingSystem, input);
                    break;
                case 4:
                    System.out.println("Book Seat");
                    bookSeat(bookingSystem, input);
                    break;
                case 5:
                    System.out.println("Cancel Booking");
                    cancelBooking(bookingSystem, input);
                    break;
                case 6:
                    System.out.println("Lookup Booking");
                    break;
                case 7:
                    System.out.println("View All Bookings");
                    break;
                case 8:
                    System.out.println("Add Flight");
                    break;
                case 9:
                    System.out.println("Exit");
                    return;
                default:
                    break;
            }
        }
        input.close();
    }

    private static void cancelBooking(BookingSystem bookingSystem, Scanner input) {
        System.out.print("Please enter your booking reference: ");
        String bookingReference = input.next();
        Booking b = bookingSystem.getBooking(bookingReference);
        if (b == null) {
            System.out.println("Booking not found!");
        } else {
            bookingSystem.cancelBooking(bookingReference);
            System.out.println("Booking cancelled!");
        }
    }

    private static void bookSeat(BookingSystem bookingSystem, Scanner input) {
        System.out.print("Please enter a flight number: ");
        String number = input.next();
        Flight flight = bookingSystem.getFlightByNumber(number);
        if (flight == null) {
            System.out.println("Flight not found!");
            return;
        }
        System.out.print("Please enter the Seat number: ");
        String seatNumber = input.next();
        List<Seat> getAvailabeSeat = flight.getAvailableSeats();
        for (int i = 0; i < getAvailabeSeat.size(); i++) {
            if (seatNumber.equals(getAvailabeSeat.get(i).getSeatNumber())) {
                System.out.print("Please enter your first name: ");
                String name = input.next();
                System.out.print("Please enter your idNumber: ");
                String idNumber = input.next();
                System.out.print("Please enter your contact details: ");
                String contact = input.next();
                Passenger passenger = new Passenger(name, idNumber, contact);
                Booking b = bookingSystem.bookSeat(flight, getAvailabeSeat.get(i), passenger);
                if (b != null) {
                    System.out.println(b);
                    System.out.println("Seat Booked!");
                    return;
                }
            }
        }
        for (int i = 0; i < flight.getSeat().size(); i++) {
            if (seatNumber.equals(flight.getSeat().get(i).getSeatNumber())) {
                System.out.println("Seat is already Booked!");
                return;
            }
        }
        System.out.println("Seat does'nt exist!");
    }

    private static void seatMap(BookingSystem bookingSystem, Scanner input) {
        System.out.print("Please enter a flight number: ");
        String number = input.next();
        Flight flight = bookingSystem.getFlightByNumber(number);
        if (flight != null) {
            List<Seat> seatMap = bookingSystem.viewSeatMap(flight);
            for (int i = 0; i < seatMap.size(); i++) {
                System.out.println(seatMap.get(i));
            }
        } else {
            System.out.println("Flight not found!");
        }
    }

    private static void searchFlight(BookingSystem bookingSystem, Scanner input) {
        System.out.print("Please enter the country code of the airport you want to fly from:");
        String origin = input.next();
        System.out.print("Please enter the country code of the airport you want to fly to:");
        String destination = input.next();
        System.out.print("Please enter the date you want to travel YYYY-MM-DD:");
        String dateString = input.next();
        LocalDate date = LocalDate.parse(dateString);
        List<Flight> results = bookingSystem.searchFlights(origin, destination, date);
        if (!results.isEmpty()) {
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i));
            }
        } else {
            System.out.println("No results found!");
        }
    }

    private static void viewRoutes(BookingSystem bookingSystem) {
        List<String> routes = new ArrayList<>();
        String route = null;
        for (int i = 0; i < bookingSystem.getFlights().size(); i++) {
            if (!routes.contains(bookingSystem.getFlights().get(i).getOrigin().getCode() + " ---> "
                    + bookingSystem.getFlights().get(i).getDestination().getCode())) {
                route = bookingSystem.getFlights().get(i).getOrigin().getCode() + " ---> "
                        + bookingSystem.getFlights().get(i).getDestination().getCode();
                routes.add(route);
            }
        }
        for (int i = 0; i < routes.size(); i++) {
            System.out.println(routes.get(i));
        }
    }

    private static void seedData(BookingSystem bookingSystem) {
        Airport lhr = new Airport("LHR", "London Hethrow", "London");
        Airport jfk = new Airport("JFK", "John F Kennedy", "New York");
        Airport dxb = new Airport("DXB", "Dubai International", "Dubai");
        Airport cdg = new Airport("CDG", "Charles de Gaulle", "Paris");
        Airport sin = new Airport("SIN", "Changi", "Singapore");

        Aircraft boeing = new Aircraft("Boeing 737", 20, 6, 3);
        Aircraft airbus = new Aircraft("Airbus A380", 30, 8, 5);

        Flight ba101 = new Flight("BA101", lhr, jfk, boeing, LocalDateTime.of(2026, 3, 20, 14, 30), 450);
        bookingSystem.addFlight(ba101);
        Flight ba102 = new Flight("BA102", jfk, lhr, boeing, LocalDateTime.of(2026, 3, 20, 9, 0), 470);
        bookingSystem.addFlight(ba102);
        Flight ek201 = new Flight("EK201", lhr, dxb, airbus, LocalDateTime.of(2026, 3, 21, 22, 0), 600);
        bookingSystem.addFlight(ek201);
        Flight af305 = new Flight("AF305", cdg, sin, airbus, LocalDateTime.of(2026, 3, 23, 11, 15), 820);
        bookingSystem.addFlight(af305);
        Flight ba103 = new Flight("BA103", lhr, jfk, airbus, LocalDateTime.of(2026, 3, 24, 16, 45), 500);
        bookingSystem.addFlight(ba103);
    }

}
