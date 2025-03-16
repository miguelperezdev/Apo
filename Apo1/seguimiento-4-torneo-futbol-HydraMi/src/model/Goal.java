package model;

public class Goal {
    private Player scorer;
    private Player assistant;
    private int minute;

    /**
     * Constructs a Goal with a scorer and an assistant.
     * 
     * <pre>
     * pre: Scorer must not be null; minute must be a valid minute of the match (0-90).
     * post: A Goal object is created with the provided scorer, assistant, and minute.
     * </pre>
     * 
     * @param scorer The Player who scored the goal.
     * @param assistant The Player who assisted the goal.
     * @param minute The minute in which the goal was scored.
     */
    public Goal(Player scorer, Player assistant, int minute) {
        this.scorer = scorer;
        this.assistant = assistant;
        this.minute = minute;
    }
 /**
     * Constructs a Goal with a scorer and without an assistant.
     * 
     * <pre>
     * pre: Scorer must not be null; minute must be a valid minute of the match (0-90).
     * post: A Goal object is created with the provided scorer and minute.
     * </pre>
     * 
     * @param scorer The Player who scored the goal.
     * @param minute The minute in which the goal was scored.
     */
    public Goal(Player scorer, int minute) {
        this(scorer, null, minute);

    }
/**
     * Gets the Player who scored the goal.
     * 
     * <pre>
     * pre: None.
     * post: Returns the Player who scored the goal.
     * </pre>
     * 
     * @return The scorer of the goal.
     */
    public Player getScorer() {
        return scorer;
    }
/**
     * Sets the Player who scored the goal.
     * 
     * <pre>
     * pre: Scorer must not be null.
     * post: The scorer of the goal is updated.
     * </pre>
     * 
     * @param scorer The Player who scored the goal.
     */
    public void setScorer(Player scorer) {
        this.scorer = scorer;
    }
/**
     * Gets the Player who assisted the goal.
     * 
     * <pre>
     * pre: None.
     * post: Returns the Player who assisted the goal.
     * </pre>
     * 
     * @return The assistant of the goal, or null if there is none.
     */
    public Player getAssistant() {
        return assistant;
    }
/**
     * Sets the Player who assisted the goal.
     * 
     * <pre>
     * pre: Assistant can be null.
     * post: The assistant of the goal is updated.
     * </pre>
     * 
     * @param assistant The Player who assisted the goal.
     */
    public void setAssistant(Player assistant) {
        this.assistant = assistant;
    }
/**
     * Gets the minute the goal was scored.
     * 
     * <pre>
     * pre: None.
     * post: Returns the minute the goal was scored.
     * </pre>
     * 
     * @return The minute of the goal.
     */
    public int getMinute() {
        return minute;
    }
/**
     * Sets the minute the goal was scored.
     * 
     * <pre>
     * pre: Minute must be a valid minute of the match (0-90).
     * post: The minute of the goal is updated.
     * </pre>
     * 
     * @param minute The minute of the goal.
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }
/**
     * Returns a string representation of the goal.
     * 
     * <pre>
     * pre: None.
     * post: Returns a string detailing the scorer, assistant (if any), and the minute of the goal.
     * </pre>
     * 
     * @return A string representation of the goal.
     */
    @Override
    public String toString() {
        if (assistant != null) {
            return "Goal scored by: " + scorer.getName() +
                    "assisted by: " + assistant.getName() +
                    "at minute: " + minute;
        } else {
            return "Goal scored by: " + scorer.getName() +
                    "at minute: " + minute;
        }
    }
}
