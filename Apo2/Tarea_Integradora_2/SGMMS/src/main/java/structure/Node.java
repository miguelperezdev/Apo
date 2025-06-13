package structure;

import map.Zone;

import java.util.Objects;

public class Node {
    private String id;
    private double x, y;
    private boolean isWalkable;
    private boolean isHouse = false;
    private Zone typeZone;
    public Node(String id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.isWalkable = true;
        this.isHouse = false;

    }

    public boolean isHouse() {
        return isHouse;
    }
    public void setHouse(boolean isHouse) {
        this.isHouse = isHouse;
    }

    public String getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isWalkable() {
        return isWalkable;
    }

    public Zone getTypeZone() {
        return typeZone;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id == node.id;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
