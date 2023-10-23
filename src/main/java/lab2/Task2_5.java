package lab2;

public class Task2_5 {

    public static String getMessageAboutSigningOfNumbers(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array must not be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("array must not be empty");
        }

        boolean doesContainPositive = false;
        boolean doesContainNegative = false;
        for (int num : array) {
            if (num > 0 && !doesContainPositive) {
                doesContainPositive = true;
            } else if (num < 0 && !doesContainNegative) {
                doesContainNegative = true;
            }
        }

        String message = "Array ";
        if (doesContainPositive && doesContainNegative) {
            message += "contains both positive and negative numbers";
        } else if (doesContainPositive) {
            message += "is full of only positive numbers";
        } else if (doesContainNegative) {
            message += "is full of only negative numbers";
        } else  {
            message += "is full of 0's";
        }

        System.out.println(message);
        return message;
    }
}
