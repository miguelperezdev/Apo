package model;
 /**
 * Represents a community with its details.
 */
 public class Community {
    private String name;
    private String type;
    private String representativeName;
    private String representativePhone;
    private int numberOfInhabitants;
    private String[] problems;
    /**
     * Constructor for the Community class.
     * 
     * @param name Name of the community
     * @param type Type of the community
     * @param representativeName Name of the community representative
     * @param representativePhone Phone number of the community representative
     * @param numberOfInhabitants Number of inhabitants in the community
     * @param problems Array of problems faced by the community
     */
    public Community(String name, String type, String representativeName, String representativePhone, int numberOfInhabitants, String[] problems) {
        this.name = name;
        this.type = type;
        this.representativeName = representativeName;
        this.representativePhone = representativePhone;
        this.numberOfInhabitants = numberOfInhabitants;
        this.problems = problems;
    }

    public Community(String communityName, CommunityType communityType, String representativeName2,
            String representativePhone2, int inhabitants) {
    
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getRepresentativeName() { return representativeName; }
    public void setRepresentativeName(String representativeName) { this.representativeName = representativeName; }

    public String getRepresentativePhone() { return representativePhone; }
    public void setRepresentativePhone(String representativePhone) { this.representativePhone = representativePhone; }

    public int getNumberOfInhabitants() { return numberOfInhabitants; }
    public void setNumberOfInhabitants(int numberOfInhabitants) { this.numberOfInhabitants = numberOfInhabitants; }

    public String[] getProblems() { return problems; }
    public void setProblems(String[] problems) { this.problems = problems; }
}
