package lab6;
import javax.swing.*;
import java.awt.*;

public class Task6_26 extends JFrame {
    private final TextPaneHandler textPaneHandler;

    public Task6_26() {
        setTitle("Task6_26");
        setSize(1920, 1080);
        setLayout(new BorderLayout());

        JTextPane textPane = new JTextPane();
        textPaneHandler = new TextPaneHandler(textPane);

        Label styleLabel = new Label("Style:");
        Choice styleChoice = new Choice();
        styleChoice.add("Plain");
        styleChoice.add("Bold");
        styleChoice.add("Italic");
        styleChoice.select(0);

        Label sizeLabel = new Label("Size:");
        Choice sizeChoice = new Choice();
        sizeChoice.add("10pt");
        sizeChoice.add("12pt");
        sizeChoice.add("14pt");
        sizeChoice.select(1);

        styleChoice.addItemListener(e -> textPaneHandler.setPaneStyle(styleChoice.getSelectedItem()));
        sizeChoice.addItemListener(e -> textPaneHandler.setPaneSize(sizeChoice.getSelectedItem()));

        Panel fontPanel = new Panel();
        fontPanel.setLayout(new FlowLayout());
        fontPanel.add(styleLabel);
        fontPanel.add(styleChoice);
        fontPanel.add(sizeLabel);
        fontPanel.add(sizeChoice);

        add(fontPanel, BorderLayout.NORTH);
        add(new JScrollPane(textPane), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Task6_26::new);
    }
}

