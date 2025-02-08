package bodyes;
import java.math.*;

public abstract class CelestialBody {
    private String name;
    private double coordinateX;
    private double coordinateY;

    public CelestialBody(String name, double coordinateX, double coordinateY) {
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }
    public double distanceTo(double x, double y) {
        return Math.sqrt(Math.pow(coordinateX - x, 2) + Math.pow(coordinateY - y, 2));
    }
    abstract public void showDetails();
    public String getName() {
        return name;
    }
    public double getCoordinateX() {
        return coordinateX;
    }
    public double getCoordinateY() {
        return coordinateY;
    }
}
