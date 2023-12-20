package lab5;

/**
 * The Animal class represents an animal with attributes such as species, weight, and height.
 * It provides methods to get and set these attributes.
 *
 * @author Andrii Cherevatyi
 */
public class Animal {

    /**
     * The species of the animal.
     */
    private String species;

    /**
     * The weight of the animal.
     */
    private double weight;

    /**
     * The height of the animal.
     */
    private double height;

    /**
     * Gets the species of the animal.
     *
     * @return The species of the animal.
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Sets the species of the animal.
     *
     * @param species The species of the animal.
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Gets the weight of the animal.
     *
     * @return The weight of the animal.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the animal.
     *
     * @param weight The weight of the animal.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets the height of the animal.
     *
     * @return The height of the animal.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the animal.
     *
     * @param height The height of the animal.
     */
    public void setHeight(double height) {
        this.height = height;
    }
}

