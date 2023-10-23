package lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLab2 {
    //TASK 2_5
    @Test
    public void shouldReturnCorrectMessage() {
        int[] array = {1, 2, -4, 6};
        String expected = "Array contains both positive and negative numbers";

        String actual = Task2_5.getMessageAboutSigningOfNumbers(array);

        assertEquals(expected, actual);
    }

    //TASK 2_10
    @Test
    public void shouldReturnCorrectArray() {
        int[] array = {1, 1, 1, 4, 5, 4, 6, 5};
        int[] expected = {3, 3, 3, 2, 2, 2, 1, 2};

        int[] actual = Task2_10.getArrayOfElementRepetition(array);

        assertArrayEquals(expected, actual);
    }

    //TASK 2_25
    @Test
    public void shouldReturnDayOfTheYear() {
        String[] the30thOfAprilLeap = new String[] {"30", "4", "true"};
        int expected = 121;

        int actual = Task2_25.getDayOfYearOfDate(the30thOfAprilLeap);

        assertEquals(expected, actual);
    }


}
