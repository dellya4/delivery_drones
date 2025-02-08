package delivery;

import bodyes.*;
import drones.*;
import cargoes.*;

import java.util.Objects;

public class DeliveryTask {
    private CelestialBody origin;
    private CelestialBody destination;
    private Cargo cargo;
    private Drone completeDelivery;

    public DeliveryTask() {}
    public DeliveryTask(CelestialBody origin, CelestialBody destination, Cargo cargo) {
        this.origin = origin;
        this.destination = destination;
        this.cargo = cargo;
    }
    public boolean assignDrone(Drone drone) {
        if (Objects.equals(drone.getStatus(), "IDLE")) {
            if (drone.checkCargo(cargo.getWeight())) {
                drone.loadCargo(cargo);
                this.completeDelivery = drone;
                System.out.println("Drone " + drone.getId() + " sent from "
                        + origin.getName() + " в " + destination.getName());
                return true;
            }
            else {
                System.out.println("Drone "+ drone.getId() + " can't take this cargo!");
                return false;
            }
        } else {
            System.out.println("Drone "+ drone.getId() + " currently is busy!");
            return false;
        }
    }
    public void completeDelivery() {
        if (completeDelivery != null) {
            double distance = origin.distanceTo(destination.getCoordinateX(), destination.getCoordinateY());
            double time = completeDelivery.calculateFlightTime(distance);
            System.out.println("The drone arrived for " + time + " hours.");
            completeDelivery.unloadCargo();
        } else {
            System.out.println("The mission is not assigned to the drone!");
        }
    }
    public void assignChoice(int choice, DeliveryTask deliveryTask) {
        if (choice == 1) {
            deliveryTask.completeDelivery();
        }
        else {
            System.out.println("Okay! Thank you for choosing us!");
        }
    }
}
