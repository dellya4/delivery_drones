import bodyes.*;
import drones.*;
import cargoes.*;
import delivery.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Drone[] drones = new Drone[100];
    static Planet earth = new Planet("oxygen", "The Earth", 0.0, 0.0);
    static Planet titan = new Planet("nitrogen", "The Titan", 55.0, 100.0);
    static SpaceStation moon = new SpaceStation(3, "Moon", 25.0, 40.0);

    public static void main(String[] args) {
        drones[0] = new HeavyDrone("HD01", "IN_FLIGHT", 1000.0, 500.0);
        drones[1] = new HeavyDrone("HD02", "IDLE", 1000.0, 0.0);
        drones[2] = new LightDrone("LD02", "IDLE", 500.0, 0.0);

        System.out.println("Hello! We work with drones. Do you want to choose an existing drone or create a new one? (1 - existing, 2 - new)");
        int firstStep = sc.nextInt();

        if (firstStep == 1) {
            Drone selectedDrone = chooseExistingDrone();
            Cargo cargo = createCargo();
            assignDeliveryTask(selectedDrone, cargo);
        } else if (firstStep == 2) {
            Drone newDrone = createNewDrone();
            Cargo cargo = createCargo();
            assignDeliveryTask(newDrone, cargo);
        }
    }

    private static Cargo createCargo() {
        System.out.println("Enter the weight of your cargo:");
        double weight = sc.nextDouble();
        System.out.println("Enter a description for your cargo:");
        String description = sc.nextLine();
        Cargo cargo = new Cargo(weight, description);
        return cargo;
    }

    private static Drone chooseExistingDrone() {
        System.out.println("Available drones:");
        for (Drone drone : drones) {
            if (drone != null) {
                System.out.println(drone.toString());
            }
        }
        System.out.println("Enter the ID of the drone you want to select:");
        String id = sc.next();
        for (Drone drone : drones) {
            if (drone != null && drone.getId().equals(id)) {
                return drone;
            }
        }
        System.out.println("Drone not found. Please try again.");
        return chooseExistingDrone();
    }

    private static Drone createNewDrone() {
        System.out.println("Which type of drone would you like to create? (1 - Heavy, 2 - Light)");
        int droneChoice = sc.nextInt();
        System.out.println("Enter the cargo capacity of your drone (Max = 1500):");
        double capacity = sc.nextDouble();
        if (droneChoice == 1) {
            return new HeavyDrone("HD" + (int)(Math.random() * 100), "IDLE", capacity, 0.0);
        } else if (droneChoice == 2) {
            return new LightDrone("LD" + (int)(Math.random() * 100), "IDLE", capacity, 0.0);
        } else {
            System.out.println("Invalid choice. Please try again.");
            return createNewDrone();
        }
    }

    private static void assignDeliveryTask(Drone drone, Cargo cargo) {
        System.out.println("We are on Earth. Where would you like to send your cargo? (1 - Titan, 2 - Moon)");
        int destinationChoice = sc.nextInt();
        DeliveryTask deliveryTask = null;
        if (destinationChoice == 1) {
            deliveryTask = new DeliveryTask(earth, titan, cargo);
            if (!deliveryTask.assignDrone(drone)) {
                createCargo();
            }
        } else if (destinationChoice == 2) {
            deliveryTask = new DeliveryTask(earth, titan, cargo);
            if (!deliveryTask.assignDrone(drone)) {
                createCargo();
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
            assignDeliveryTask(drone, cargo);
            return;
        }
        System.out.println("Would you like to know when your drone will reach the destination? (1 - Yes, 2 - No)");
        int notifyChoice = sc.nextInt();
        deliveryTask.assignChoice(notifyChoice, deliveryTask);
    }
}
