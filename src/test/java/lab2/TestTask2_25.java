package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2_25 {
    @Test
    public void shouldReturnDayOfTheYear() {
        String[] the30thOfAprilLeap = new String[] {"30", "4", "true"};

        int expected = 121;

        int actual = Task2_25.getDayOfYearOfDate(the30thOfAprilLeap);

        assertEquals(expected, actual);
    }
}
