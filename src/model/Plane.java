package model;

import java.util.ArrayList;
import java.util.List;

public class Plane {

    private int id;
    private String name;
    private int numberOfSeatRows;
    private char numberOfSeatsInRow;
    private List<Seat> seats;


    public Plane(int id, String name, int countOfSeatRows, char numberOfSeatsInRow) {
        setId(id);
        setName(name);
        this.numberOfSeatRows = countOfSeatRows;
        this.numberOfSeatsInRow = numberOfSeatsInRow;
        createSeats(countOfSeatRows, numberOfSeatsInRow);
    }


    private void createSeats(int countOfSeatRows, char maxNumberOfSeatsInRow) {
        if (countOfSeatRows < 1 || Character.isLowerCase(maxNumberOfSeatsInRow) || !Character.isLetter(maxNumberOfSeatsInRow)) {
            System.out.println("Passed wrong parameter for countOfSeatRows or maxNumberOfSeatsInRow: ");
            return;
        }

        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= countOfSeatRows; i++) {
            for (char j = 'A'; j <= maxNumberOfSeatsInRow; j++) {
                seats.add(new Seat(i, j));
            }
        }
        this.seats = seats;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            System.out.println("Id must be a positive number: ");
            return;
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Passed null or empty value as a name parameter: ");
            return;
        }
        this.name = name;
    }

    public int getNumberOfSeatRows() {
        return numberOfSeatRows;
    }

    public void setNumberOfSeatRows(int numberOfSeatRows) {
        if (numberOfSeatRows <= 0){
            System.out.println("Passed parameter must be positive number: ");
            return;
        }
        this.numberOfSeatRows = numberOfSeatRows;
    }

    public char getNumberOfSeatsInRow() {
        return numberOfSeatsInRow;
    }

    public void setNumberOfSeatsInRow(char numberOfSeatsInRow) {
        if (!Character.isLetter(numberOfSeatsInRow) && Character.isLowerCase(numberOfSeatsInRow)){
            System.out.println("Passed parameter must be an uppercase letter: ");
            return;
        }
        this.numberOfSeatsInRow = numberOfSeatsInRow;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        if (seats == null || seats.isEmpty()){
            System.out.println("Passed null or empty value: ");
            return;
        }
        this.seats = seats;
    }


    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfSeatRows=" + numberOfSeatRows +
                ", numberOfSeatsInRow=" + numberOfSeatsInRow +
                "}\n";
    }
}