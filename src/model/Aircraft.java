package model;

import java.util.ArrayList;
import java.util.List;
import model.enums.SeatClass;

public class Aircraft {
    private String model;
    private int rows;
    private int seatsPerRow;
    private int businessRows;

    public Aircraft(String model, int rows, int seatsPerRow, int businessRows) {
        this.model = model;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.businessRows = businessRows;
    }

    public String getModel() {
        return model;
    }

    public int getSeatCapacity() {
        return rows * seatsPerRow;
    }

    // v1: uniform row width; realistic variable-width cabins are a future
    // enhancement
    public List<Seat> generateSeatmap() {
        List<Seat> s = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                int rowNumber = i + 1;
                char position = (char) ((char) 'A' + j);
                SeatClass seatClass;
                String seatNumber = (Integer.toString(rowNumber)) + position;
                if (businessRows >= rowNumber) {
                    seatClass = SeatClass.BUSINESS;
                } else {
                    seatClass = SeatClass.ECONOMY;
                }
                Seat seat = new Seat(seatNumber, seatClass);
                s.add(seat);
            }
        }
        return s;

    }

}
