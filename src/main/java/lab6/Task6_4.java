package lab6;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task6_4 extends Frame {
    private int width = 50;
    private int height = 50;

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    private final Checkbox widthCheckbox;
    private final Checkbox heightCheckbox;

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

        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resizeFigure(10);
                canvas.repaint();
            }
        });

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resizeFigure(-10);
                canvas.repaint();
            }
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

    public void resizeFigure(int delta) {
        if (widthCheckbox.getState()) {
            width += delta;
        }

        if (heightCheckbox.getState()) {
            height += delta;
        }
    }

    public static void main(String[] args) {
        new Task6_4();
    }
}


