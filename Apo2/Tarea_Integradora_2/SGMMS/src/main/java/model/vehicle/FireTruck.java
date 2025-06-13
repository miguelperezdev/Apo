package model.vehicle;

import javafx.scene.image.Image;
import model.vehicle.PriorityLevel;
import java.util.ArrayList;
import java.util.List;

public class FireTruck extends Vehicle {

    public FireTruck(double x, double y, double speed) {
        super(x, y, speed, PriorityLevel.HIGH);
    }

    @Override
    protected void loadSprites() {
        animations.put(Direction.UP,    loadFrames("firetruck", 36, 36));
        animations.put(Direction.RIGHT, loadFrames("firetruck", 0, 0));
        animations.put(Direction.DOWN,  loadFrames("firetruck", 12, 12));
        animations.put(Direction.LEFT,  loadFrames("firetruck", 24, 24));
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
