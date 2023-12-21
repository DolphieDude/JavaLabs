package lab6;

import org.junit.jupiter.api.Test;

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
}
