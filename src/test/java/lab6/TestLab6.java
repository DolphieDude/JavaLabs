package lab6;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
