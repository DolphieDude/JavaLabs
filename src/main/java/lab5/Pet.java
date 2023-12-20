package lab5;

/**
 * The Pet class represents a pet, extending the Animal class, with additional attributes such as name and owner.
 * It provides methods to get and set these attributes.
 *
 * @author Andrii Cherevatyi
 * @see Animal
 */
public class Pet extends Animal {

    /**
     * The name of the pet.
     */
    private String name;

    /**
     * The owner of the pet.
     */
    private String owner;

    /**
     * Gets the name of the pet.
     *
     * @return The name of the pet.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the pet.
     *
     * @param name The name of the pet.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the owner of the pet.
     *
     * @return The owner of the pet.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the pet.
     *
     * @param owner The owner of the pet.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
}
