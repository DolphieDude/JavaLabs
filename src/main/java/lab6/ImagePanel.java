package lab6;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * A custom JPanel that displays an image and provides methods to manipulate its size.
 */
public class ImagePanel extends JPanel {

    /**
     * The original image loaded from a file.
     */
    private Image originalImage;

    /**
     * The resized image to be displayed on the panel.
     */
    private Image resizedImage;

    /**
     * Constructs an {@code ImagePanel} with the default image loaded from a file.
     * The image is loaded from the file "C:\\Users\\Admin\\Desktop\\prsnl\\KPI STUDY\\k-5_mem.jpg".
     */
    public ImagePanel() {
        try {
            originalImage = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\prsnl\\KPI STUDY\\k-5_mem.jpg"));
            resizedImage = originalImage;
        } catch (IOException e) {
            System.out.println("No needed file");
        }
    }

    /**
     * Constructs an {@code ImagePanel} with a specified image loaded from a file and resized to the given dimensions.
     *
     * @param imagePath the path to the image file
     * @param width     the width of the resized image
     * @param height    the height of the resized image
     */
    public ImagePanel(String imagePath, int width, int height) {
        try {
            originalImage = ImageIO.read(new File(imagePath));
            resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            System.out.println("No needed file");
        }
    }

    /**
     * Gets the original image loaded from a file.
     *
     * @return the original image
     */
    public Image getOriginalImage() {
        return originalImage;
    }

    /**
     * Gets the resized image to be displayed on the panel.
     *
     * @return the resized image
     */
    public Image getResizedImage() {
        return resizedImage;
    }

    /**
     * Resizes the image by a specified percentage for width and height.
     *
     * @param widthPercent  the percentage to resize the width
     * @param heightPercent the percentage to resize the height
     */
    public void resizeImage(int widthPercent, int heightPercent) {
        int newWidth = (int) (originalImage.getWidth(null) * widthPercent / 100.0);
        int newHeight = (int) (originalImage.getHeight(null) * heightPercent / 100.0);

        resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        repaint();
    }

    /**
     * Overrides the {@code paintComponent} method to draw the resized image on the panel.
     *
     * @param g the Graphics context
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(resizedImage, 0, 0, this);
    }

    /**
     * The main method to create and display an instance of {@code ImagePanel}.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImagePanel::new);
    }
}
