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
    /**
     * Gets the ID of the person.
     * 
     * <pre>
     * pre: None.
     * post: Returns the ID of the person.
     * </pre>
     * 
     * @return The ID of the person.
     */
    public String getId() {
        return id;
    }
/**
     * Sets the ID of the person.
     * 
     * <pre>
     * pre: ID must not be null or empty.
     * post: The ID of the person is updated.
     * </pre>
     * 
     * @param id The new ID for the person.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name of the person.
     * 
     * <pre>
     * pre: None.
     * post: Returns the name of the person.
     * </pre>
     * 
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }
 /**
     * Sets the name of the person.
     * 
     * <pre>
     * pre: Name must not be null or empty.
     * post: The name of the person is updated.
     * </pre>
     * 
     * @param name The new name for the person.
     */
    public void setName(String name) {
        this.name = name;
    }
/**
     * Gets the country of the person.
     * 
     * <pre>
     * pre: None.
     * post: Returns the country of the person.
     * </pre>
     * 
     * @return The country of the person.
     */
    public String getCountry() {
        return country;
    }
/**
     * Sets the country of the person.
     * 
     * <pre>
     * pre: Country must not be null or empty.
     * post: The country of the person is updated.
     * </pre>
     * 
     * @param country The new country for the person.
     */
    public void setCountry(String country) {
        this.country = country;
    }
/**
     * Returns a string representation of the person.
     * 
     * <pre>
     * pre: None.
     * post: Returns a string detailing the ID, name, and country of the person.
     * </pre>
     * 
     * @return A string representation of the person.
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Country: " + country;
    }

    
}
