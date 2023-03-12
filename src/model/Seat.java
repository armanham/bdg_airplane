package model;

public class Seat {

    private int numberOfRow;
    private char numberInRow;
    private SeatState state;

    public Seat(int numberOfRow, char numberInRow) {
        setNumberOfRow(numberOfRow);
        setNumberInRow(numberInRow);
        this.state = SeatState.AVAILABLE;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public void setNumberOfRow(int numberOfRow) {
        if (numberOfRow <= 0) {
            System.out.println("Number of rows must be a positive number: ");
            return;
        }
        this.numberOfRow = numberOfRow;
    }

    public char getNumberInRow() {
        return numberInRow;
    }

    public void setNumberInRow(char numberInRow) {
        if (Character.isLowerCase(numberInRow)) {
            System.out.println("Number of seat in row must be a letter in uppercase format: ");
            return;
        }
        this.numberInRow = numberInRow;
    }

    public SeatState getState() {
        return state;
    }

    public void setState(SeatState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "numberOfRow=" + numberOfRow +
                ", numberInRow=" + numberInRow +
                ", state=" + state +
                "}\n";
    }
}