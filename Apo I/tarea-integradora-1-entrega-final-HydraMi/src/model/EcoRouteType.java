package model;
    /**
    * Represents different types of ecological routes with their details.
    */
    public enum EcoRouteType {
    FARALLONES("Street 16 - University of Valle", "6:40 am", "2:30 pm"),
    LADERA("Boulevard del Rio", "7:00 am", "1:30 pm"),
    EAST("Boulevard del Rio", "7:00 am", "1:00 pm");

    private String meetingPoint;
    private String startTime;
    private String endTime;
    /**
     * Constructs an EcoRouteType with specified details.
     * @param meetingPoint the meeting point for the eco route
     * @param startTime the start time for the eco route
     * @param endTime the end time for the eco route
     */
    EcoRouteType(String meetingPoint, String startTime, String endTime) {
        this.meetingPoint = meetingPoint;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    /**
     * Retrieves the meeting point for the eco route.
     * @return the meeting point
     */
    public String getMeetingPoint() {
        return meetingPoint;
    }
    /**
     * Retrieves the start time for the eco route.
     * @return the start time
     */
    public String getStartTime() {
        return startTime;
    }
    /**
     * Retrieves the end time for the eco route.
     * @return the end time
     */
    public String getEndTime() {
        return endTime;
    }
}
