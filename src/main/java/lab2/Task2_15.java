package lab2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//it is assumed that both array a and array b are sets, that is, each of them does not contain elements with the same values
public class Task2_15 {
    public static List<Integer> getArrayOfCommonElements(int[] array1, int[] array2) {
        HashSet<Integer> setOfAllElements = new HashSet<>();
        LinkedList<Integer> commonElements = new LinkedList<>();

        for (int element : array1) {
            setOfAllElements.add(element);
        }
        for (int element : array2) {
            if (setOfAllElements.contains(element)) {
                commonElements.add(element);
            }
        }

        System.out.println(commonElements);

        return commonElements;
    }
}
