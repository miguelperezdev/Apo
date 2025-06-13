package model;
    /**
     * Enumeration representing the weather conditions for eco routes.
     */
public enum WeatherCondition {
    GOOD_DAY("It's a nice day for a walk in Cali!"),
    BAD_DAY("It's not a good day for a walk.");

    private String message;
    /**
     * Constructs a WeatherCondition with the specified message.
     * @param message the message associated with the weather condition
     */
    WeatherCondition(String message) {
        this.message = message;
    }
    /**
     * Retrieves the message associated with the weather condition.
     * @return the message for this weather condition
     */
    public String getMessage() {
        return message;
    }
}
