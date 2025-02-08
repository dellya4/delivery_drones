package drones;

public class HeavyDrone extends Drone {
    public HeavyDrone(String id, String status, double cargoCapacity, double currentCargoWeight) {
        super(id, status, cargoCapacity, currentCargoWeight);
    }

    @Override
    public double calculateFlightTime(double distance) {
        return distance/1.5;
    }
}
