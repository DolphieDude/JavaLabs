package lab4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Task4_4 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < 5; i++) {
            list.add(i);
            set.add(i);
        }

        String input = "";
        Integer toAdd;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Current list: " + list);
            System.out.print("Write what number you would like to add: ");
            try {
                input = scanner.nextLine();
                toAdd = Integer.valueOf(input);
                if (set.contains(toAdd)) {
                    throw new Exception();
                }
            } catch (Exception e) {
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Wrong input");
                continue;
            }


            list.add(toAdd);
            set.add(toAdd);
        }

    }
}
