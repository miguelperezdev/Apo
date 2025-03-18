package model;

    /**
    * Represents a species in the biodiversity management application.
     */
    public class Species {
    private String name;
    private SpeciesType type;
    private String photoPath; 
    private int numberOfIndividuals;

     /**
     * Constructs a Species object with the specified details.
     * @param name the name of the species
     * @param type the type of the species (Flora or Fauna)
     * @param photoPath the path to the species' photo
     * @param numberOfIndividuals the number of individuals of this species
     */
    public Species(String name, SpeciesType type, String photoPath, int numberOfIndividuals) {
        this.name = name;
        this.type = type;
        this.photoPath = photoPath;
        this.numberOfIndividuals = numberOfIndividuals;
    }

    /**
     * Retrieves the name of the species.
     * @return the name of the species
     */
    public String getName() { return name; }

    /**
     * Sets the name of the species.
     * @param name the new name for the species
     */
    public void setName(String name) { this.name = name; }

    /**
     * Retrieves the type of the species.
     * @return the type of the species
     */
    public SpeciesType getType() { return type; }

    /**
     * Sets the type of the species.
     * @param type the new type for the species
     */
    public void setType(SpeciesType type) { this.type = type; }

    /**
     * Retrieves the path to the photo of the species.
     * @return the photo path
     */
    public String getPhotoPath() { return photoPath; }

    /**
     * Sets the path to the photo of the species.
     * @param photoPath the new photo path
     */
    public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }

    /**
     * Retrieves the number of individuals of this species.
     * @return the number of individuals
     */
    public int getNumberOfIndividuals() { return numberOfIndividuals; }

    /**
     * Sets the number of individuals of this species.
     * @param numberOfIndividuals the new number of individuals
     */
    public void setNumberOfIndividuals(int numberOfIndividuals) { this.numberOfIndividuals = numberOfIndividuals; }
}
