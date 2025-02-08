package cargoes;

public class Cargo {
    private double weight;
    private String description;

    public Cargo() {}
    public Cargo(double weight, String description) {
        this.weight = weight;
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }
    public String getDescription() {
        return description;
    }
}
