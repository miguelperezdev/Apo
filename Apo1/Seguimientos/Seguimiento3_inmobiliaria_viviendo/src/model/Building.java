package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a building with a list of apartments.
 */
public class Building {
    private String name;
    private String address;
    private int apartmentCount;
    private List<Apartment> apartments;

    /**
     * Constructs a Building object.
     * @param name the unique name of the building
     * @param address the address of the building
     * @param apartmentCount the maximum number of apartments in the building
     */
    public Building(String name, String address, int apartmentCount) {
        this.name = name;
        this.address = address;
        this.apartmentCount = apartmentCount;
        this.apartments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    /**
     * Adds an apartment to the building.
     * @param apartment the apartment to be added
     */
    public void addApartment(Apartment apartment) {
        if (apartments.size() < apartmentCount) {
            apartments.add(apartment);
            System.out.println("Apartment " + apartment.getNumber() + " registered successfully.");
        } else {
            System.out.println("No more apartments can be added to this building.");
        }
    }

    /**
     * Gets the number of available apartments.
     * @return the number of available apartments
     */
    public int getAvailableApartments() {
        return apartmentCount - apartments.size();
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    /**
     * Gets the total rental value of all apartments in the building.
     * @return the total rental value
     */
    public double getTotalRentValue() {
        return apartments.stream().mapToDouble(Apartment::getMonthlyRent).sum();
    }
}
