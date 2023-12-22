package lab6;
import java.awt.*;

import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task6_30 extends JFrame {

    private final ImagePanel imagePanel;
    private final JSlider widthSlider;
    private final JSlider heightSlider;

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
        controlPanel.add(new JLabel("Width:"));
        controlPanel.add(widthSlider);
        controlPanel.add(new JLabel("Height:"));
        controlPanel.add(heightSlider);
        controlPanel.add(resizeButton);

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);

        setVisible(true);
    }

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task6_30::new);
    }
}


