package lab4;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Task4_26 {

    public static void main(String[] args) {
        HashMap<Integer, Article> cart = new HashMap<>();
        TreeSet<String> nameSet = new TreeSet<>();

        Integer keyToPut = 44;
        cart.put(keyToPut, new Article("Shorts", 233.5f));
        nameSet.add(cart.get(keyToPut).getName());

        keyToPut = 5667;
        cart.put(keyToPut, new Article("Phone", 45.f));
        nameSet.add(cart.get(keyToPut).getName());

        keyToPut = 78;
        cart.put(keyToPut, new Article("Batteries", 8.9f));
        nameSet.add(cart.get(keyToPut).getName());

        keyToPut = 524;
        cart.put(keyToPut, new Article("Brcelet", 32.6f));
        nameSet.add(cart.get(keyToPut).getName());

        keyToPut = 9;
        cart.put(keyToPut, new Article("Book", 4.33f));
        nameSet.add(cart.get(keyToPut).getName());

        String input = "";
        Integer key;
        String name;
        float price;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Current cart:");
            for (Integer articulus: cart.keySet()) {
                System.out.println(articulus + ": " +
                                   cart.get(articulus).getName() + " - " + cart.get(articulus).getPrice());
            }

            System.out.print("Write what articulus you would like to buy: ");
            try {
                input = scanner.nextLine();
                key = Integer.valueOf(input);
                if (cart.containsKey(key)) {
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

            cart.put(key, new Article(name, price));
            nameSet.add(name);
        }
    }
}
