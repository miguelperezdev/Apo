package model.vehicle;

import javafx.scene.image.Image;
import model.vehicle.PriorityLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un vehículo de atención prioritaria
 * (como una ambulancia, patrulla o camión de bomberos).
 */
public class Priority extends Vehicle {

    private final String folder;

    public Priority(String folder, double x, double y, double speed) {
        super(x, y, speed, PriorityLevel.HIGH);
        this.folder = folder;
        loadSprites();
    }

    @Override
    protected void loadSprites() {
        animations.put(Direction.UP,    loadFrames("priority/" + folder, 36, 36));
        animations.put(Direction.RIGHT, loadFrames("priority/" + folder, 0, 0));
        animations.put(Direction.DOWN,  loadFrames("priority/" + folder, 12, 12));
        animations.put(Direction.LEFT,  loadFrames("priority/" + folder, 24, 24));
    }

    private List<Image> loadFrames(String folderPath, int start, int end) {
        List<Image> frames = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            String frameNum = String.format("%03d", i);
            String path = String.format("/images/%s/%s.png", folderPath, frameNum);
            var stream = getClass().getResourceAsStream(path);
            if (stream != null) {
                frames.add(new Image(stream));
            } else {
                System.err.println("Imagen no encontrada: " + path);
            }
        }
        return frames;
    }

    @Override
    public String toString() {
        return folder + " en (" + (int)x + ", " + (int)y + ")";
    }
}
