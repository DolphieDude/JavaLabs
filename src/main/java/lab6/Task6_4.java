package lab6;
import java.awt.*;

/**
 * Task6_4 class represents a graphical window with controls to resize a figure.
 * The figure can be resized in both width and height using checkboxes and buttons.
 */
public class Task6_4 extends Frame {
    private int width = 50;
    private int height = 50;

    /**
     * Checkbox for controlling whether to resize the width of the figure.
     */
    private final Checkbox widthCheckbox;

    /**
     * Checkbox for controlling whether to resize the height of the figure.
     */
    private final Checkbox heightCheckbox;

    /**
     * Creates an instance of the Task6_4 class, initializing the graphical window with controls.
     */
    public Task6_4() {
        setTitle("Task6_4");
        setSize(400, 300);
        setLayout(new BorderLayout());

        Canvas canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.drawRect(getWidth() / 2 - width / 2, getHeight() / 2 - height / 2, width, height);
            }
        };
        canvas.setBackground(Color.WHITE);
        add(canvas, BorderLayout.CENTER);

        Panel controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        Label label = new Label("Parameter:");
        controlPanel.add(label);

        widthCheckbox = new Checkbox("Width", true);
        heightCheckbox = new Checkbox("Height", true);

        controlPanel.add(widthCheckbox);
        controlPanel.add(heightCheckbox);

        Button increaseButton = new Button("Increase");
        Button decreaseButton = new Button("Decrease");

        increaseButton.addActionListener(e -> {
            resizeFigure(10);
            canvas.repaint();
        });

        decreaseButton.addActionListener(e -> {
            resizeFigure(-10);
            canvas.repaint();
        });

        controlPanel.add(increaseButton);
        controlPanel.add(decreaseButton);

        add(controlPanel, BorderLayout.SOUTH);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    /**
     * Resizes the figure based on the specified delta values for width and height.
     *
     * @param delta the amount by which to resize the figure
     */
    public void resizeFigure(int delta) {
        if (widthCheckbox.getState()) {
            width += delta;
        }

        if (heightCheckbox.getState()) {
            height += delta;
        }
    }

    /**
     * The main method to create and display an instance of Task6_4.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        new Task6_4();
    }
}
