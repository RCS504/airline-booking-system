package model;

import model.enums.BookingStatus;
import java.time.LocalDateTime;

public class Booking {
    private String reference;
    private Passenger passenger;
    private Flight flight;
    private Seat seat;
    private BookingStatus bookingStatus;
    private LocalDateTime timeStamp;

    public Booking(String reference, Passenger passenger, Flight flight, Seat seat) {
        this.reference = reference;
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
        bookingStatus = BookingStatus.CONFIRMED;
        timeStamp = LocalDateTime.now();
    }

    public String getReference() {
        return reference;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {
        return ("Reference: " + reference + " [" + bookingStatus + "] -- " + timeStamp + "\n" + passenger + "\n"
                + flight + "\n" + seat);
    }

}
