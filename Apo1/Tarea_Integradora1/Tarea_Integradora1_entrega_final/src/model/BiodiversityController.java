package model;
/**
 * Controls the management of biodiversity places.
 */
public class BiodiversityController {
    private BiodiversityPlace[] places; 
    private int count;
    /**
     * Constructor for the BiodiversityController class.
     * Initializes the places array with a capacity for 30 places.
     */
    public BiodiversityController() {
        places = new BiodiversityPlace[30]; 
        count = 0;
    }
    /**
     * Adds a new biodiversity place to the controller.
     * 
     * @param place The biodiversity place to be added
     * @return true if the place was added successfully, false if the limit is reached
     */
    public boolean addPlace(BiodiversityPlace place) {
        if (count < 30) {
            places[count++] = place;
            return true;
        }
        return false;
    }
    /**
     * Gets the list of biodiversity places ordered by area.
     * 
     * @return An array of biodiversity places ordered by area
     */
    public BiodiversityPlace[] getPlacesOrderedByArea() {
        BiodiversityPlace[] orderedPlaces = new BiodiversityPlace[count];
        System.arraycopy(places, 0, orderedPlaces, 0, count);
        
        for (int i = 0; i < orderedPlaces.length - 1; i++) {
            for (int j = 0; j < orderedPlaces.length - 1 - i; j++) {
                if (orderedPlaces[j].getArea() > orderedPlaces[j + 1].getArea()) {
                    BiodiversityPlace temp = orderedPlaces[j];
                    orderedPlaces[j] = orderedPlaces[j + 1];
                    orderedPlaces[j + 1] = temp;
                }
            }
        }
        return orderedPlaces;
    }
      /**
     * Gets the department with the most biodiversity places.
     * 
     * @return The department with the highest number of places
     */

    public Department getDepartmentWithMostPlaces() {
        int[] departmentCounts = new int[Department.values().length];

        for (int i = 0; i < count; i++) {
            departmentCounts[places[i].getDepartment().ordinal()]++;
        }

        int maxIndex = 0;
        for (int i = 1; i < departmentCounts.length; i++) {
            if (departmentCounts[i] > departmentCounts[maxIndex]) {
                maxIndex = i;
            }
        }

        return Department.values()[maxIndex];
    }

    /**
     * Gets the array of biodiversity places.
     * @return The array of biodiversity places
     */
    public BiodiversityPlace[] getPlaces() {
        return places;
    }

    /**
     * Gets the current count of biodiversity places.
     * @return The number of biodiversity places
     */
    public int getCount() {
        return count;
    }
}
