package lab6;

import java.awt.*;

/**
 * Task6_11 class represents a graphical window with controls to change the color
 * and move a filled rectangle within a canvas.
 */
public class Task6_11 extends Frame {
    private int x = 200;
    private int y = 150;
    private final int width = 50;
    private final int height = 50;
    private Color currentColor = Color.BLACK;

    /**
     * The canvas where the filled rectangle is displayed.
     */
    private Canvas canvas;

    /**
     * Gets the current x-coordinate of the filled rectangle.
     *
     * @return the x-coordinate
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Gets the current y-coordinate of the filled rectangle.
     *
     * @return the y-coordinate
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Gets the current color of the filled rectangle.
     *
     * @return the color of the rectangle
     */
    public Color getCurrentColor() {
        return currentColor;
    }

    /**
     * Gets the canvas where the filled rectangle is displayed.
     *
     * @return the canvas component
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * Creates an instance of the Task6_11 class, initializing the graphical window
     * with controls for color selection and movement of the filled rectangle.
     */
    public Task6_11() {
        setTitle("Task6_11");
        setSize(400, 300);
        setLayout(new BorderLayout());

        canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(currentColor);
                g.fillRect(x, y, width, height);
            }
        };
        canvas.setBackground(Color.WHITE);
        add(canvas, BorderLayout.CENTER);

        Panel controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        Label colorLabel = new Label("Color:");
        controlPanel.add(colorLabel);

        Choice colorChoice = new Choice();
        colorChoice.add("Black");
        colorChoice.add("Red");
        colorChoice.add("Green");
        colorChoice.add("Blue");
        colorChoice.select(0); // Default: Black
        colorChoice.addItemListener(e -> changeColor(colorChoice.getSelectedItem()));
        controlPanel.add(colorChoice);

        Button leftButton = new Button("Left");
        Button upButton = new Button("Up");
        Button rightButton = new Button("Right");
        Button downButton = new Button("Down");

        leftButton.addActionListener(e -> moveFigure(-10, 0, canvas));
        upButton.addActionListener(e -> moveFigure(0, -10, canvas));
        rightButton.addActionListener(e -> moveFigure(10, 0, canvas));
        downButton.addActionListener(e -> moveFigure(0, 10, canvas));

        controlPanel.add(leftButton);
        controlPanel.add(upButton);
        controlPanel.add(rightButton);
        controlPanel.add(downButton);

        add(controlPanel, BorderLayout.SOUTH);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    /**
     * Changes the color of the filled rectangle based on the selected color name.
     *
     * @param colorName the name of the selected color
     */
    public void changeColor(String colorName) {
        switch (colorName.toLowerCase()) {
            case "red":
                currentColor = Color.RED;
                break;
            case "green":
                currentColor = Color.GREEN;
                break;
            case "blue":
                currentColor = Color.BLUE;
                break;
            default:
                currentColor = Color.BLACK;
        }
        repaint();
    }

    /**
     * Moves the filled rectangle by the specified delta values in the x and y directions
     * within the given canvas boundaries.
     *
     * @param deltaX the change in x-coordinate
     * @param deltaY the change in y-coordinate
     * @param canvas the canvas component
     */
    public void moveFigure(int deltaX, int deltaY, Canvas canvas) {
        int newX = x + deltaX;
        int newY = y + deltaY;

        if (newX >= 0 && newY >= 0 && newX + width <= canvas.getWidth() && newY + height <= canvas.getHeight()) {
            x = newX;
            y = newY;
            canvas.repaint();
        }
    }

    /**
     * The main method to create and display an instance of Task6_11.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        new Task6_11();
    }
}
