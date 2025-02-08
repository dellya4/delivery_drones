package drones;

import cargoes.Cargo;

import java.util.Objects;

public abstract class Drone {
    private String id;
    private String status;
    private double cargoCapacity;
    private double currentCargoWeight;

    public Drone () {}
    public Drone (String id, String status, double cargoCapacity, double currentCargoWeight) {
        this.id = id;
        this.status = status;
        this.cargoCapacity = cargoCapacity;
        this.currentCargoWeight = currentCargoWeight;
    }

    public boolean checkCargo(double weight) {
        if (weight <= cargoCapacity) {
            return true;
        }
        return false;
    }

    public void loadCargo (Cargo cargo) {
        if (checkCargo(cargo.getWeight())) {
            this.currentCargoWeight = cargo.getWeight();
            this.status = "IN_FLIGHT";
        }
        else {
            System.out.println("Cargo does not exist");
        }
    }
    public void unloadCargo () {
        if (Objects.equals(getStatus(), "IN_FLIGHT")) {
            System.out.println("Weight load "+currentCargoWeight+" delivered by drone " + id);
            this.currentCargoWeight = 0;
            this.status = "IDLE";
        } else {
            System.out.println("Drone "+getId()+" has chill.");
        }
    }
    public abstract double calculateFlightTime(double distance);

    public String getId() {
        return id;
    }
    public String getStatus() {
        return status;
    }
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public String toString() {
        return "id: "+getId()+" status: "+getStatus()+" cargoCapacity: "+getCargoCapacity();
    }
}
