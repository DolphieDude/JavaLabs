package lab4;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Task4_15 {
    public static void main(String[] args) {
        HashMap<Integer, Article> orders = new HashMap<>();
        TreeSet<String> nameSet = new TreeSet<>();

        Integer keyToPut = 44;
        orders.put(keyToPut, new Article("Eggs", 23.5f));
        nameSet.add(orders.get(keyToPut).getName());

        keyToPut = 5667;
        orders.put(keyToPut, new Article("Milk", 45.f));
        nameSet.add(orders.get(keyToPut).getName());

        keyToPut = 78;
        orders.put(keyToPut, new Article("Bottle of water", 8.9f));
        nameSet.add(orders.get(keyToPut).getName());

        keyToPut = 524;
        orders.put(keyToPut, new Article("Tomatoes", 32.6f));
        nameSet.add(orders.get(keyToPut).getName());

        keyToPut = 9;
        orders.put(keyToPut, new Article("Salt", 4.33f));
        nameSet.add(orders.get(keyToPut).getName());

        String input = "";
        Integer key;
        String name;
        float price;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Current orders:");
            for (Integer articulus: orders.keySet()) {
                System.out.println(articulus + ": " +
                        orders.get(articulus).getName() + " - " + orders.get(articulus).getPrice());
            }

            System.out.print("Write what articulus you would like to add: ");
            try {
                input = scanner.nextLine();
                key = Integer.valueOf(input);
                if (orders.containsKey(key)) {
                    throw new RuntimeException();
                }

                System.out.print("Write name: ");
                input = scanner.nextLine();
                if (nameSet.contains(input)) {
                    throw new RuntimeException();
                }
                name = input;

                System.out.print("Write price: ");
                input = scanner.nextLine();
                price = Float.parseFloat(input);
            } catch (Exception e) {
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Wrong input");
                continue;
            }

            orders.put(key, new Article(name, price));
            nameSet.add(name);
        }
    }
}
