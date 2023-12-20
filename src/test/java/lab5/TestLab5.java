package lab5;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestLab5 {

    //TASK 5_4
    @Test
    public void shouldAddNewWeatherInfoAndPrintExisting() {
        final InputStream originalIn = System.in;

        final PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream;

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

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

        System.setIn(originalIn);
        System.setOut(originalOut);
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

    //TASK 5_26
    @Test
    void testSolve() {
        int[][] matrixData = {{2, 3}, {4, 5}};
        Matrix coefficientMatrix = new Matrix(matrixData);
        int[] freeTerms = {8, 18};

        LinearEquationSystem equationSystem = new LinearEquationSystem(coefficientMatrix, freeTerms);

        double[] solution = equationSystem.solve();

        double[] expected = {7.0, -2.0}; // Adjust format to match double precision

        assertArrayEquals(expected, solution, 1e-10);
    }

    @Test
    void testSolveWithNoSolution() {
        int[][] matrixData = {{2, 3}, {4, 6}};
        Matrix coefficientMatrix = new Matrix(matrixData);
        int[] freeTerms = {8, 18};
        LinearEquationSystem equationSystem = new LinearEquationSystem(coefficientMatrix, freeTerms);
        assertThrows(ArithmeticException.class, equationSystem::solve);
    }

    @Test
    void testSolveWithInfinitelyManySolutions() {
        int[][] matrixData = {{2, 3}, {4, 6}};
        Matrix coefficientMatrix = new Matrix(matrixData);
        int[] freeTerms = {4, 9};
        LinearEquationSystem equationSystem = new LinearEquationSystem(coefficientMatrix, freeTerms);
        assertThrows(ArithmeticException.class, equationSystem::solve);
    }

    @Test
    void testToString() {
        int[][] matrixData = {{2, 3}, {4, 5}};
        Matrix coefficientMatrix = new Matrix(matrixData);
        int[] freeTerms = {8, 18};

        LinearEquationSystem equationSystem = new LinearEquationSystem(coefficientMatrix, freeTerms);

        String expected = "2x + 3y = 8\n4x + 5y = 18\n";

        String actual = equationSystem.toString();

        System.out.println("Expected:\n" + expected);
        System.out.println("Actual:\n" + actual);

        assertEquals(expected, actual);
    }

}
