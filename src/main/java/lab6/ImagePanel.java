package lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class ImagePanel extends JPanel {

    private Image originalImage;
    private Image resizedImage;

    public ImagePanel() {
        try {
            originalImage = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\prsnl\\KPI STUDY\\k-5_mem.jpg"));
            resizedImage = originalImage;
        } catch (IOException e) {
            System.out.println("No needed file");
        }
    }

    public ImagePanel(String imagePath, int width, int height) {
        try {
            originalImage = ImageIO.read(new File(imagePath));
            resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            System.out.println("No needed file");
        }
    }

    public Image getOriginalImage() {
        return originalImage;
    }

    public Image getResizedImage() {
        return resizedImage;
    }

    public void resizeImage(int widthPercent, int heightPercent) {
        int newWidth = (int) (originalImage.getWidth(null) * widthPercent / 100.0);
        int newHeight = (int) (originalImage.getHeight(null) * heightPercent / 100.0);

        resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(resizedImage, 0, 0, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImagePanel::new);
    }
}
