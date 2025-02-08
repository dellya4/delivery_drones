package drones;

public class LightDrone extends Drone {
    public LightDrone(String id, String status, double cargoCapacity, double currentCargoWeight) {
        super(id, status, cargoCapacity, currentCargoWeight);
    }

    @Override
    public double calculateFlightTime(double distance) {
        return distance/2;
    }
}
