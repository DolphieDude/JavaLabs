package lab2;

import java.util.Arrays;

public class Task2_20 {
    public static double[] getPercentagesOfElementsDependingOnAverage(int[] array) {
        double lessThan = 0, equal = 0, moreThan = 0; //Percentages of elements %VAR_NAME% array's average
        int average = Arrays.stream(array).sum() / array.length;

        for (int element : array) {
            if (element < average) {
                lessThan++;
                continue;
            }
            if (element == average) {
                equal++;
                continue;
            }
            moreThan++;
        }

        lessThan = calculatePercentage(lessThan, array.length);
        equal = calculatePercentage(equal, array.length);
        moreThan = calculatePercentage(moreThan, array.length);

        System.out.println("Average = " + average);
        System.out.println("Percentage of elements less than average = " + lessThan + "%");
        System.out.println("Percentage of elements equal average = " + equal + "%");
        System.out.println("Percentage of elements more than average = " + moreThan + "%");

        return new double[]{lessThan, equal, moreThan};
    }

    private static double calculatePercentage(double part, double whole) {
        return (part / whole) * 100.;
    }
}
