package bodyes;
public class SpaceStation extends CelestialBody {
    private int stationLevel;

    public SpaceStation( int stationLevel, String name, double coordinateX, double coordinateY ) {
        super( name, coordinateX, coordinateY );
        this.stationLevel = stationLevel;
    }

    @Override
    public void showDetails() {
        System.out.println("Station: " + stationLevel);
    }
}
