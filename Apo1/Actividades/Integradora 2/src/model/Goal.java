package model;

public class Goal {
    private Player scorer;
    private Player assistant;
    private int minute;

    public Goal(Player scorer, Player assistant, int minute) {
        this.scorer = scorer;
        this.assistant = assistant;
        this.minute = minute;
    }

    public Goal(Player scorer, int minute) {
        this(scorer, null, minute);
    }

    public Player getScorer() {
        return scorer;
    }

    public void setScorer(Player scorer) {
        this.scorer = scorer;
    }

    public Player getAssistant() {
        return assistant;
    }

    public void setAssistant(Player assistant) {
        this.assistant = assistant;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        if (assistant != null) {
            return "Goal scored by: " + scorer.getName() +
                    " assisted by: " + assistant.getName() +
                    " at minute: " + minute;
        } else {
            return "Goal scored by: " + scorer.getName() +
                    " at minute: " + minute;
        }
    }
}
