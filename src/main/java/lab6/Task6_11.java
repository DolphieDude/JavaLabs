package lab6;
import java.awt.*;

public class Task6_11 extends Frame {
    private int x = 200;
    private int y = 150;
    private final int width = 50;
    private final int height = 50;
    private Color currentColor = Color.BLACK;

    private Canvas canvas;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public Canvas getCanvas() {
        return canvas;
    }

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

    public void moveFigure(int deltaX, int deltaY, Canvas canvas) {
        int newX = x + deltaX;
        int newY = y + deltaY;

        if (newX >= 0 && newY >= 0 && newX + width <= canvas.getWidth() && newY + height <= canvas.getHeight()) {
            x = newX;
            y = newY;
            canvas.repaint();
        }
    }

    public static void main(String[] args) {
        new Task6_11();
    }


}


