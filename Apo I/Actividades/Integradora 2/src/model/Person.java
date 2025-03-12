package model;

public class Person {
    private String id;
    private String name;
    private String country;
/**
     * Constructs a Person with specified ID, name, and country.
     * 
     * <pre>
     * pre: ID, name, and country must not be null or empty.
     * post: A Person object is created with the provided ID, name, and country.
     * </pre>
     * 
     * @param id The unique identifier for the person.
     * @param name The name of the person.
     * @param country The country of the person.
     */
    public Person(String id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
        return "ID: " + id + ", Name: " + name + ", Country: " + country;
    }

    
}
