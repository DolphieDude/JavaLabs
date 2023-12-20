package lab5;

/**
 * The {@code Line} class represents a line segment in a two-dimensional plane.
 * It is defined by two sets of coordinates: (beginX, beginY) and (endX, endY).
 * The class provides methods to retrieve and modify the coordinates, as well as
 * functionality to calculate the length of the line and move it in the plane.
 *
 * @author Andrii Cherevatyi
 */
public class Line {
    /**
     * The X-coordinate of the starting point of the line.
     */
    private int beginX;

    /**
     * The Y-coordinate of the starting point of the line.
     */
    private int beginY;

    /**
     * The X-coordinate of the ending point of the line.
     */
    private int endX;

    /**
     * The Y-coordinate of the ending point of the line.
     */
    private int endY;

    /**
     * Constructs a Line object with specified coordinates.
     *
     * @param beginX The X-coordinate of the starting point.
     * @param beginY The Y-coordinate of the starting point.
     * @param endX   The X-coordinate of the ending point.
     * @param endY   The Y-coordinate of the ending point.
     */
    public Line(int beginX, int beginY, int endX, int endY) {
        this.beginX = beginX;
        this.beginY = beginY;
        this.endX = endX;
        this.endY = endY;
    }

    /**
     * Gets the X-coordinate of the starting point of the line.
     *
     * @return The X-coordinate of the starting point.
     */
    public int getBeginX() {
        return beginX;
    }

    /**
     * Sets the X-coordinate of the starting point of the line.
     *
     * @param beginX The X-coordinate of the starting point.
     */
    public void setBeginX(int beginX) {
        this.beginX = beginX;
    }

    /**
     * Gets the Y-coordinate of the starting point of the line.
     *
     * @return The Y-coordinate of the starting point.
     */
    public int getBeginY() {
        return beginY;
    }

    /**
     * Sets the Y-coordinate of the starting point of the line.
     *
     * @param beginY The Y-coordinate of the starting point.
     */
    public void setBeginY(int beginY) {
        this.beginY = beginY;
    }

    /**
     * Gets the X-coordinate of the ending point of the line.
     *
     * @return The X-coordinate of the ending point.
     */
    public int getEndX() {
        return endX;
    }

    /**
     * Sets the X-coordinate of the ending point of the line.
     *
     * @param endX The X-coordinate of the ending point.
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * Gets the Y-coordinate of the ending point of the line.
     *
     * @return The Y-coordinate of the ending point.
     */
    public int getEndY() {
        return endY;
    }

    /**
     * Sets the Y-coordinate of the ending point of the line.
     *
     * @param endY The Y-coordinate of the ending point.
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * Calculates the length of the line using the distance formula.
     *
     * @return The length of the line.
     */
    public double calculateLength() {
        return Math.sqrt(Math.pow(endX - beginX, 2) + Math.pow(endY - beginY, 2));
    }

    /**
     * Moves the line by specified delta values for both X and Y coordinates.
     *
     * @param deltaX The amount to move in the X direction.
     * @param deltaY The amount to move in the Y direction.
     */
    public void move(int deltaX, int deltaY) {
        beginX += deltaX;
        beginY += deltaY;
        endX += deltaX;
        endY += deltaY;
    }
}
