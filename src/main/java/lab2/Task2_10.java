package lab2;

import java.util.Arrays;
import java.util.HashMap;

public class Task2_10 {
    public static int[] getArrayOfElementRepetition(int[] array) {
        int[] result = new int[array.length];

        HashMap<Integer, Integer> repetitionMap = new HashMap<>();

        for (int element : array) {
            if (repetitionMap.containsKey(element)) {
                repetitionMap.put(element, repetitionMap.get(element) + 1);
                continue;
            }

            repetitionMap.put(element, 1);
        }

        for (int i = 0; i < array.length; i++) {
            result[i] = repetitionMap.get(array[i]);
        }

        System.out.println(Arrays.toString(result));

        return result;
    }
}
