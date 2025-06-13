package model.vehicle;

import javafx.scene.image.Image;
import model.vehicle.PriorityLevel;
import java.util.ArrayList;
import java.util.List;

public class Ambulance extends Vehicle {

    public Ambulance(double x, double y, double speed) {
        super(x, y, speed, PriorityLevel.HIGH);
    }

    @Override
    protected void loadSprites() {
        animations.put(Direction.UP,    loadFrames("ambulance", 36, 36));
        animations.put(Direction.RIGHT, loadFrames("ambulance", 0, 0));
        animations.put(Direction.DOWN,  loadFrames("ambulance", 12, 12));
        animations.put(Direction.LEFT,  loadFrames("ambulance", 24, 24));
    }

    private List<Image> loadFrames(String folder, int start, int end) {
        List<Image> frames = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            String path = String.format("/images/%s/%03d.png", folder, i);
            var stream = getClass().getResourceAsStream(path);
            if (stream != null) frames.add(new Image(stream));
            else System.out.println("⚠️ Imagen no encontrada: " + path);
        }
        return frames;
    }
}
