package model;

public class Apartment {
    private int number;
    private ApartmentType type;
    private double monthlyRent;

    public Apartment(int number, ApartmentType type, double monthlyRent) {
        this.number = number;
        this.type = type;
        this.monthlyRent = monthlyRent;
    }

    public int getNumber() {
        return number;
    }

    public ApartmentType getType() {
        return type;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }
}
