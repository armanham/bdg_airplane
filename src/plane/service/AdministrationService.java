package plane.service;

import plane.model.Plane;
import plane.model.Seat;
import plane.model.SeatState;

public class AdministrationService {

    private PlaneService planeService;

    public AdministrationService(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void reserveASeat(int idOfPlane, int numberOfRow, char numberInRow) {
        if (idOfPlane <= 0 || numberOfRow <= 0 || !Character.isLetter(numberInRow) || Character.isLowerCase(numberInRow)) {
            throw new IllegalArgumentException("Passed wrong parameter: ");
        }
        Plane plane = planeService.findBy(idOfPlane);
        if (plane == null) {
            System.out.println("Plane in this id does not exists: ");
            return;
        }


        for (Seat seat : plane.getSeats()) {
            if (seat.getState() == SeatState.AVAILABLE) {
                if (seat.getNumberOfRow() == numberOfRow && seat.getNumberInRow() == numberInRow) {
                    seat.setState(SeatState.RESERVED);
                    System.out.println("Seat " + numberOfRow + numberInRow + " is reserved successfully: ");
                    return;
                }
            } else {
                System.out.println("Sorry... Seat " + numberOfRow + numberInRow + " already reserved: ");
            }
        }
    }


    public void cancelAReserve(int idOfPlane, int numberOfRow, char numberInRow) {
        if (idOfPlane <= 0 || numberOfRow <= 0 || !Character.isLetter(numberInRow) || Character.isLowerCase(numberInRow)) {
            throw new IllegalArgumentException("Passed wrong parameter: ");
        }

        Plane plane = planeService.findBy(idOfPlane);
        if (plane == null) {
            System.out.println("Plane in this id does not exists: ");
            return;
        }

        for (Seat seat : plane.getSeats()) {
            if (seat.getState() == SeatState.RESERVED) {
                if (seat.getNumberOfRow() == numberOfRow && seat.getNumberInRow() == numberInRow) {
                    seat.setState(SeatState.AVAILABLE);
                    System.out.println("Reserve for Seat " + numberOfRow + numberInRow + " is canceled successfully: ");
                    return;
                }
            } else {
                System.out.println("Seat " + numberOfRow + numberInRow + " never been reserved: ");
                return;
            }
        }
    }
}