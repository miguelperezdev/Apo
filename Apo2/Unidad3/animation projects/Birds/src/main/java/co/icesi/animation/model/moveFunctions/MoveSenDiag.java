package co.icesi.animation.model.moveFunctions;

import co.icesi.animation.model.BirdController;

public class MoveSenDiag implements MoveFunction{

    @Override
    public double move(double x, double... params) {
        double val = Math.cos(x * Math.PI / 180) * 100 +x;
        val = -val;
        val+= BirdController.HEIGHT;
        return val;
    }
}
