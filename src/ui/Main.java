package ui;

import system.BookingSystem;
import model.Aircraft;
import model.Airport;
import model.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        seedData(bookingSystem);
        System.out.println(bookingSystem.searchFlights("LHR", "JFK", LocalDate.of(2026, 3, 20)));
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
