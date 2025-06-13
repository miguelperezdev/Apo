package model;

/**
 * Represents the real estate management system.
 */
public class RealEstate {
    private Building[] buildings;
    private int buildingCount;

    /**
     * Constructs a RealEstate object.
     */
    public RealEstate() {
        buildings = new Building[50];
        buildingCount = 0;
    }

    /**
     * Adds a building to the real estate.
     * @param building the building to be added
     */
    public void addBuilding(Building building) {
        if (buildingCount < 50) {
            for (int i = 0; i < buildingCount; i++) {
                if (buildings[i].getName().equalsIgnoreCase(building.getName())) {
                    System.out.println("Building with this name already exists.");
                    return;
                }
            }
            buildings[buildingCount++] = building;
            System.out.println("Building " + building.getName() + " registered successfully.");
        } else {
            System.out.println("Cannot register more buildings.");
        }
    }

    /**
     * Gets a building by its name.
     * @param name the name of the building
     * @return the building if found, otherwise null
     */
    public Building getBuilding(String name) {
        for (Building building : buildings) {
            if (building != null && building.getName().equalsIgnoreCase(name)) {
                return building;
            }
        }
        return null;
    }

    /**
     * Gets the total income from all apartments.
     * @return the total income
     */
    public double getTotalIncome() {
        double totalRent = 0;
        for (Building building : buildings) {
            if (building != null) {
                totalRent += building.getTotalRentValue();
            }
        }
        return totalRent;
    }

    /**
     * Gets the real estate's income (10%).
     * @return the real estate income
     */
    public double getRealEstateIncome() {
        return getTotalIncome() * 0.10;
    }

    /**
     * Gets the owner's income (90%).
     * @return the owner's income
     */
    public double getOwnerIncome() {
        return getTotalIncome() * 0.90;
    }
}
