package plane.service;

import plane.model.Plane;

import java.util.ArrayList;
import java.util.List;

public class PlaneService {

    private List<Plane> planes = new ArrayList<>();


    public Plane create(String name, int countOfSeatRows, char numberOfSeatsInRow) {
        if (countOfSeatRows <= 0 || Character.isLowerCase(numberOfSeatsInRow) || !Character.isLetter(numberOfSeatsInRow)) {
            throw new IllegalArgumentException("Passed illegal parameter: ");
        }

        int idOfLastPlane = planes.size();
        Plane newPlane = new Plane(idOfLastPlane + 1, name, countOfSeatRows, numberOfSeatsInRow);

        planes.add(newPlane);
        return newPlane;
    }


    public boolean deleteBy(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Passed illegal parameter: ");
        }

        return planes.remove(findBy(id));
    }


    public Plane findBy(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Passed illegal parameter: ");
        }

        for (Plane item : planes) {
            if (id == item.getId()) {
                return item;
            }
        }
        return null;
    }


    public List<Plane> getAllBy(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Passed null or empty value as a name parameter: ");
        }

        List<Plane> listPlanesWithSameName = new ArrayList<>();
        for (Plane item : planes) {
            if (item.getName().equals(name)) {
                listPlanesWithSameName.add(item);
            }
        }
        return listPlanesWithSameName;
    }


    public List<Plane> getPlanes() {
        return planes;
    }
}