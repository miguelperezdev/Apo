package model.vehicle;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction fromDelta(double dx, double dy) {
        dx = Math.signum(dx);
        dy = Math.signum(dy);

        if (dx == 0 && dy < 0) return UP;
        if (dx == 0 && dy > 0) return DOWN;
        if (dx < 0 && dy == 0) return LEFT;
        if (dx > 0 && dy == 0) return RIGHT;

        return DOWN;
    }
}
