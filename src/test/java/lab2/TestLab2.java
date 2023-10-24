package lab2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLab2 {
    //TASK 2_5
    @Test
    public void shouldReturnMessageAboutMixedSigningArray() {
        int[] array = {1, 2, -4, 6};
        String expected = "Array contains both positive and negative numbers";

        String actual = Task2_5.getMessageAboutSigningOfNumbers(array);

        assertEquals(expected, actual);
    }

    //TASK 2_10
    @Test
    public void shouldReturnArrayOfElementRepetition() {
        int[] array = {1, 1, 1, 4, 5, 4, 6, 5};
        int[] expected = {3, 3, 3, 2, 2, 2, 1, 2};

        int[] actual = Task2_10.getArrayOfElementRepetition(array);

        assertArrayEquals(expected, actual);
    }

    //TASK 2_15
    @Test
    public void shouldReturnArrayOfCommonElements() {
        int[] array1 = {2, 5, 6, 3, 8, 432, 21, 64};
        int[] array2 = {5, 7, 21, 83, 432, 1, 0, 1212};
        List<Integer> expected = Arrays.asList(5, 21, 432);

        List<Integer> actual = Task2_15.getArrayOfCommonElements(array1, array2);

        assertEquals(expected, actual);
    }

    //TASK 2_20
    @Test
    public void shouldReturnArrayOfPercentagesDependingOnAvg() {
        int[] array = {2, 4, 6, 8, 10};
        double[] expected = {40.0, 20.0, 40.0};

        double[] actual = Task2_20.getPercentagesOfElementsDependingOnAverage(array);

        assertArrayEquals(expected, actual, 0.001);
    }

    //TASK 2_24
    @Test
    public void shouldReturnDayOfTheYear() {
        String[] the30thOfAprilLeap = new String[] {"30", "4", "true"};
        int expected = 121;

        int actual = Task2_24.getDayOfYearOfDate(the30thOfAprilLeap);

        assertEquals(expected, actual);
    }


}
