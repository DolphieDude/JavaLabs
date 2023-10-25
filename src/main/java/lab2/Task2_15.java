package lab2;

import java.util.*;

//it is assumed that both array a and array b does not contain elements with the same values within one array
public class Task2_15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] array1 = input.split(" ");
        input = scanner.nextLine();
        String[] array2 = input.split(" ");
        scanner.close();

        getArrayOfCommonElements(array1, array2);
    }

    public static <T> List<T> getArrayOfCommonElements(T[] array1, T[] array2) {
        LinkedList<T> commonElements = new LinkedList<>();

        HashSet<T> setOfAllElements = new HashSet<>(Arrays.asList(array1));
        for (T element : array2) {
            if (setOfAllElements.contains(element)) {
                commonElements.add(element);
            }
        }

        System.out.println(commonElements);

        return commonElements;
    }
}
