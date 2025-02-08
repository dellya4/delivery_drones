package bodyes;

public class Planet extends CelestialBody {
    private String atmosphereType;
    public Planet(String atmosphereType, String name, double coordinateX, double coordinateY) {
        super( name, coordinateX, coordinateY );
        this.atmosphereType = atmosphereType;
    }

    @Override
    public void showDetails() {
        System.out.println("bodyes.Planet: " + atmosphereType);
    }
}
