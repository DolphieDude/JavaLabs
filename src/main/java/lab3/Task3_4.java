package lab3;

import java.util.HashMap;
import java.util.Scanner;

public class Task3_4 {
    public static void main(String[] args) {
        HashMap<Integer, String> commands = new HashMap<>();

        commands.put(1, "Say Hello");
        commands.put(2, "Say Hello to User");
        commands.put(3, "Count to 10");

        StringBuffer commandsOutput = new StringBuffer();
        for (int i = 1; commands.containsKey(i); i++) {
            if (commands.containsKey(i)) {
                commandsOutput.append(i).append(". ").append(commands.get(i)).append("\n");
            }
        }
        System.out.print(commandsOutput);

        int input;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                input = scanner.nextInt();
                if (!commands.containsKey(input)) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong input");
            }
        }

        switch (input) {
            case 1 -> sayHello();
            case 2 -> sayHelloToUser();
            case 3 -> countTo10();
        }
    }

    private static void sayHello() {
        System.out.println("Hello!");
    }

    private static void sayHelloToUser() {
        System.out.println("Hello " + System.getProperty("user.name"));
    }

    private static void countTo10() {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
    }
}
