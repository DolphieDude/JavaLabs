package lab6;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class TestLab6 {

    //TASK6_4
    @Test
    void testResizeFigure() {
        Task6_4 resizeApp = new Task6_4();

        int initialWidth = resizeApp.getWidth();
        int initialHeight = resizeApp.getHeight();

        resizeApp.resizeFigure(-10);
        int expectedWidth = initialWidth - 10;
        int expectedHeight = initialHeight - 10;

        assertEquals(expectedWidth, resizeApp.getWidth());
        assertEquals(expectedHeight, resizeApp.getHeight());

        resizeApp.resizeFigure(10);
        expectedWidth += 10;
        expectedHeight += 10;

        assertEquals(expectedWidth, resizeApp.getWidth());
        assertEquals(expectedHeight, resizeApp.getHeight());
    }

    //TASK6_11
    @Test
    void testChangeColor() {
        Task6_11 app = new Task6_11();

        assertEquals(Color.BLACK, app.getCurrentColor());

        app.changeColor("Red");
        assertEquals(Color.RED, app.getCurrentColor());

        app.changeColor("Green");
        assertEquals(Color.GREEN, app.getCurrentColor());

        app.changeColor("Blue");
        assertEquals(Color.BLUE, app.getCurrentColor());

        app.changeColor("InvalidColor");
        assertEquals(Color.BLACK, app.getCurrentColor());
    }

    @Test
    void testMoveFigure() {
        Task6_11 app = new Task6_11();
        Canvas canvas = app.getCanvas();

        int initialX = app.getX();
        int initialY = app.getY();

        app.moveFigure(-10, 0, canvas);
        int expectedX = initialX - 10;
        int expectedY = initialY;

        assertEquals(expectedX, app.getX());
        assertEquals(expectedY, app.getY());

        app.moveFigure(0, -10, canvas);
        expectedY -= 10;

        assertEquals(expectedX, app.getX());
        assertEquals(expectedY, app.getY());

        app.moveFigure(10, 0, canvas);
        expectedX += 10;

        assertEquals(expectedX, app.getX());
        assertEquals(expectedY, app.getY());

        app.moveFigure(0, 10, canvas);
        expectedY += 10;

        assertEquals(expectedX, app.getX());
        assertEquals(expectedY, app.getY());
    }

    //TASK6_26
    @Test
    void testSetPaneStyle() {
        JTextPane textPane = new JTextPane();
        TextPaneHandler textPaneHandler = new TextPaneHandler(textPane);

        textPaneHandler.setText("Test Text");  // Initialize with some content
        textPaneHandler.setPaneStyle("Bold");
        StyledDocument doc = textPane.getStyledDocument();
        AttributeSet attrs = doc.getCharacterElement(0).getAttributes();
        assertTrue(StyleConstants.isBold(attrs));
        assertFalse(StyleConstants.isItalic(attrs));

        textPaneHandler.setPaneStyle("Italic");
        attrs = doc.getCharacterElement(0).getAttributes();
        assertFalse(StyleConstants.isBold(attrs));
        assertTrue(StyleConstants.isItalic(attrs));

        textPaneHandler.setPaneStyle("Plain");
        attrs = doc.getCharacterElement(0).getAttributes();
        assertFalse(StyleConstants.isBold(attrs));
        assertFalse(StyleConstants.isItalic(attrs));
    }

    @Test
    void testSetPaneSize() {
        JTextPane textPane = new JTextPane();
        TextPaneHandler textPaneHandler = new TextPaneHandler(textPane);

        textPaneHandler.setText("Test Text");
        textPaneHandler.setPaneStyle("Bold");  // Apply Bold style to make the test more comprehensive

        textPaneHandler.setPaneSize("10pt");
        StyledDocument doc = textPane.getStyledDocument();
        AttributeSet attrs = doc.getCharacterElement(0).getAttributes();
        assertEquals(10, StyleConstants.getFontSize(attrs));

        textPaneHandler.setPaneSize("14pt");
        attrs = doc.getCharacterElement(0).getAttributes();
        assertEquals(14, StyleConstants.getFontSize(attrs));
    }

    @Test
    void testSetTextAndText() {
        JTextPane textPane = new JTextPane();
        TextPaneHandler textPaneHandler = new TextPaneHandler(textPane);

        textPaneHandler.setText("Test Text");
        assertEquals("Test Text", textPaneHandler.getText());
    }


    //TASK6_30
    private ImagePanel imagePanel;

    @Test
    void testInitialImage() {
        imagePanel = new ImagePanel();
        assertNotNull(imagePanel.getOriginalImage());
        assertNotNull(imagePanel.getResizedImage());
        assertEquals(imagePanel.getOriginalImage(), imagePanel.getResizedImage());
    }

    @Test
    void testLoadImageFromFile() {
        imagePanel = new ImagePanel();
        Path imagePath = Paths.get("C:\\Users\\Admin\\Desktop\\prsnl\\KPI STUDY\\k-5_mem.jpg");

        try {
            BufferedImage bufferedImage = ImageIO.read(imagePath.toFile());
            Image expectedImage = bufferedImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

            ImagePanel loadedImagePanel = new ImagePanel(imagePath.toString(), 100, 100);

            assertNotNull(loadedImagePanel.getOriginalImage());
            assertNotNull(loadedImagePanel.getResizedImage());
            assertEquals(expectedImage.getWidth(null), loadedImagePanel.getResizedImage().getWidth(null));
            assertEquals(expectedImage.getHeight(null), loadedImagePanel.getResizedImage().getHeight(null));
        } catch (IOException e) {
            System.out.println("No needed file");
        }
    }
}
