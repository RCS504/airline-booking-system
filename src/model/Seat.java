package model;

import model.enums.SeatStatus;
import model.enums.SeatClass;

public class Seat {
    private String seatNumber;
    private SeatClass seatClass;
    private SeatStatus seatStatus;

    public Seat(String seatNumber, SeatClass seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        seatStatus = SeatStatus.AVAILABLE;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    @Override
    public String toString() {
        return (seatNumber + " [" + seatClass + "] " + seatStatus);
    }

}
