package lab4;

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

public class TestLab4 {
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

    //TASK 4_4
    @Test
    public void shouldAddUniqueNumbers() {
        List<String> expectedOutput = Arrays.asList(
                "Current list: [0, 1, 2, 3, 4]",
                "Write what number you would like to add: " +
                "Current list: [0, 1, 2, 3, 4, 5]",
                "Write what number you would like to add: " +
                "Current list: [0, 1, 2, 3, 4, 5, 6]",
                "Write what number you would like to add: " +
                "Wrong input",
                "Current list: [0, 1, 2, 3, 4, 5, 6]",
                "Write what number you would like to add: " +
                "Current list: [0, 1, 2, 3, 4, 5, 6, 7]",
                "Write what number you would like to add:"
        );

        String input = "5\n6\n4\n7\nexIT\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task4_4.main(new String[]{});

        String[] actualOutput = outputStream.toString().split(System.lineSeparator());
        for (int i = 0; i < expectedOutput.size(); i++) {
            assertEquals(expectedOutput.get(i), actualOutput[i].trim());
        }
    }

    //TASK 4_15
    @Test
    public void shouldAddUniqueOrders() {
        String expectedOutput =
                """
                        Current orders:\r
                        5667: Milk - 45.0\r
                        9: Salt - 4.33\r
                        44: Eggs - 23.5\r
                        524: Tomatoes - 32.6\r
                        78: Bottle of water - 8.9\r
                        Write what articulus you would like to add: Write name: Write price: Current orders:\r
                        1: Test - 10.1\r
                        5667: Milk - 45.0\r
                        9: Salt - 4.33\r
                        44: Eggs - 23.5\r
                        524: Tomatoes - 32.6\r
                        78: Bottle of water - 8.9\r
                        Write what articulus you would like to add:""";

        String input = "1\nTest\n10.10\nexIT\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task4_15.main(new String[]{});

        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput.trim(), actualOutput.trim());
    }

    //TASK 4_26
    @Test
    public void shouldAddUniqueItemsToCart() {
        String expectedOutput =
                """
                        Current cart:\r
                        5667: Phone - 45.0\r
                        9: Book - 4.33\r
                        44: Shorts - 233.5\r
                        524: Brcelet - 32.6\r
                        78: Batteries - 8.9\r
                        Write what articulus you would like to buy: Write name: Write price: Current cart:\r
                        1: Test - 100.101\r
                        5667: Phone - 45.0\r
                        9: Book - 4.33\r
                        44: Shorts - 233.5\r
                        524: Brcelet - 32.6\r
                        78: Batteries - 8.9\r
                        Write what articulus you would like to buy:""";

        String input = "1\nTest\n100.101\nexIT\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Task4_26.main(new String[]{});

        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput.trim(), actualOutput.trim());
    }
}
