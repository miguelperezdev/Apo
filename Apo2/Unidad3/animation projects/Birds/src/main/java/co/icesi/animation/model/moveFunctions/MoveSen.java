package co.icesi.animation.model.moveFunctions;

public class MoveSen implements MoveFunction{
    @Override
    public double move(double x, double... params) {
        return Math.sin(x * Math.PI / 180) * 100+x;
    }
}
