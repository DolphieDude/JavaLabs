package lab4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLab4 {
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
        final InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        final PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Task4_4.main(new String[]{});
        System.setIn(originalIn);

        System.setOut(new PrintStream(new ByteArrayOutputStream()));

        String[] actualOutput = outputStream.toString().split(System.lineSeparator());
        for (int i = 0; i < expectedOutput.size(); i++) {
            assertEquals(expectedOutput.get(i), actualOutput[i].trim());
        }

        System.setOut(originalOut);
    }

    //TASK 4_15
    @Test
    public void shouldAddUniqueOrders() {
        String expectedOutput =
                "Current orders:\r\n" +
                "5667: Milk - 45.0\r\n" +
                "9: Salt - 4.33\r\n" +
                "44: Eggs - 23.5\r\n" +
                "524: Tomatoes - 32.6\r\n" +
                "78: Bottle of water - 8.9\r\n" +
                "Write what articulus you would like to add: Write name: Write price: Current orders:\r\n" +
                "1: Test - 10.1\r\n" +
                "5667: Milk - 45.0\r\n" +
                "9: Salt - 4.33\r\n" +
                "44: Eggs - 23.5\r\n" +
                "524: Tomatoes - 32.6\r\n" +
                "78: Bottle of water - 8.9\r\n" +
                "Write what articulus you would like to add:";

        String input = "1\nTest\n10.10\nexIT\n";
        final InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        final PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Task4_15.main(new String[]{});
        System.setIn(originalIn);

        System.setOut(new PrintStream(new ByteArrayOutputStream()));

        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput.trim(), actualOutput.trim());

        System.setOut(originalOut);
    }
}
