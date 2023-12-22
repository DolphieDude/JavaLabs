package lab6;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

/**
 * Task6_30 class represents a graphical window for resizing an image with width and height controls.
 */
public class Task6_30 extends JFrame {

    private final ImagePanel imagePanel;
    private final JSlider widthSlider;
    private final JSlider heightSlider;

    /**
     * Creates an instance of the Task6_30 class, initializing the graphical window
     * with sliders for controlling the width and height of an image.
     */
    public Task6_30() {
        setTitle("Task6_30");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imagePanel = new ImagePanel();
        widthSlider = createSlider(10, 150, 100);
        heightSlider = createSlider(10, 150, 100);

        JButton resizeButton = new JButton("Resize Image");
        resizeButton.addActionListener(e -> {
            int width = widthSlider.getValue();
            int height = heightSlider.getValue();
            imagePanel.resizeImage(width, height);
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(new JLabel("Width%:"));
        controlPanel.add(widthSlider);
        controlPanel.add(new JLabel("Height%:"));
        controlPanel.add(heightSlider);
        controlPanel.add(resizeButton);

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Creates a JSlider with specified minimum, maximum, and initial values.
     *
     * @param min          the minimum value of the slider
     * @param max          the maximum value of the slider
     * @param initialValue the initial value of the slider
     * @return a JSlider with specified attributes
     */
    private JSlider createSlider(int min, int max, int initialValue) {
        JSlider slider = new JSlider(min, max, initialValue);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(min, new JLabel(String.valueOf(min)));
        labelTable.put(max, new JLabel(String.valueOf(max)));
        slider.setLabelTable(labelTable);

        slider.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            int value = source.getValue();
            labelTable.put(value, new JLabel(String.valueOf(value)));
        });

        return slider;
    }

    /**
     * The main method to create and display an instance of Task6_30.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task6_30::new);
    }
}
