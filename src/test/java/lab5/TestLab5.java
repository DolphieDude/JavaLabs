package lab5;

import lab4.Task4_30;
import lab4.Task4_4;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLab5 {
    final private InputStream originalIn = System.in;

    final private PrintStream originalOut = System.out;

    private ByteArrayOutputStream outputStream;


    @BeforeEach
    public void setOutUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void returnOriginalStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    //TASK 5_4
    @Test
    public void shouldAddNewWeatherInfoAndPrintExisting() {
        String expectedOutput =
                """
                        Adding new forecast info:\r
                        Direction of wind=Speed of wind(Km/H)=Temperature(Celsius)=Precipitation=Wrong input\r
                        Humidity=List of forecasts\r
                        """;

        String input = "test test\n-1\n2\n300\n30\n40\nprint\n1\n0\nquit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task5_4.main(new String[]{});

        String actualOutput = outputStream.toString();
        assertTrue(actualOutput.trim().contains(expectedOutput.trim()));
    }

    //TASK 5_15
    @Test
    public void testCalculateLength() {
        Line line = new Line(0, 0, 3, 4);
        assertEquals(5.0, line.calculateLength(), 0.0001);
    }

    @Test
    public void testMove() {
        Line line = new Line(1, 2, 4, 6);
        line.move(2, -3);

        assertEquals(3, line.getBeginX());
        assertEquals(-1, line.getBeginY());
        assertEquals(6, line.getEndX());
        assertEquals(3, line.getEndY());
    }
}
