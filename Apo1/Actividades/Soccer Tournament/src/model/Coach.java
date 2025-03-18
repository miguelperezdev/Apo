package model;

public class Coach {
    private String name;
    private String country;

    public Coach(String name, String country) {
        this.name = name;
        this.country = country;
    }

    // Métodos getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Coach [Name=" + name + ", Country=" + country + "]";
    }
}
