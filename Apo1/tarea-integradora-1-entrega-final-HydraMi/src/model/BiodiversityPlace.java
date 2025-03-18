package model;

import java.util.Date;
/**
 * Represents a place of biodiversity with its details.
 */
public class BiodiversityPlace {
    private String name;
    private Department department;
    private float area;
    private String photo;
    private Date inaugurationDate;
    private Community community;
    private float economicResources;
    private Species[] speciesList = new Species[50]; // Up to 50 species will be stored
    private int speciesCount = 0;
    /**
     * Constructor for the BiodiversityPlace class.
     * 
     * @param name Name of the biodiversity place
     * @param department Department where the place is located
     * @param area Area of the biodiversity place
     * @param photo Path to the photo of the biodiversity place
     * @param newCommunity Community that takes care of the biodiversity place
     * @param newSpecies Initial species to add to the biodiversity place
     * @param economicResources Economic resources available for the place
     */
    public BiodiversityPlace(String name, Department department, float area, String photo, Community newCommunity, Species newSpecies, float economicResources) {
        this.name = name;
        this.department = department;
        this.area = area;
        this.photo = photo;
        this.inaugurationDate = new Date(); 
        this.community = newCommunity; 
        this.economicResources = economicResources;

        addSpecies(newSpecies); 
    }
    /**
     * Adds a species to the species list.
     * 
     * @param species The species to be added
     */
    public void addSpecies(Species species) {
        if (speciesCount < speciesList.length) {
            speciesList[speciesCount] = species;
            speciesCount++;
        } else {
            System.out.println("# Cannot add more species, limit reached.");
        }
    }
     /**
     * Modifies a species at a specified index in the species list.
     * 
     * @param index The index of the species to modify
     * @param newSpecies The new species information to set
     */
    public void modifySpecies(int index, Species newSpecies) {
        if (index >= 0 && index < speciesCount) {
            speciesList[index] = newSpecies;
        } else {
            System.out.println("# Invalid index.");
        }
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public float getArea() {
        return area;
    }
    public void setArea(float area) {
        this.area = area;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public Date getInaugurationDate() {
        return inaugurationDate;
    }
    public void setInaugurationDate(Date inaugurationDate) {
        this.inaugurationDate = inaugurationDate;
    }
    public Community getCommunity() {
        return community;
    }
    public void setCommunity(Community community) {
        this.community = community;
    }
    public float getEconomicResources() {
        return economicResources;
    }
    public void setEconomicResources(float economicResources) {
        this.economicResources = economicResources;
    }
    public Species[] getSpeciesList() {
        return speciesList;
    }
    public int getSpeciesCount() {
        return speciesCount;
    }
}
