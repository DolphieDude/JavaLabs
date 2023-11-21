package lab3;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Task3_15 {

    public static StringBuffer cipher(String message, String key, String choice) {
        StringBuffer cipherResult = new StringBuffer();
        BiFunction<Character, Character, Character> function;

        if (choice.equals("e")) {
            function = (original, keyValue) -> {
                return (char) (original + keyValue);
            };
        } else {
            function = (original, keyValue) -> {
                return (char) (original - keyValue);
            };
        }

        int j = 0;

        for (int i = 0; i < message.length(); i++) {
            char keyValue = key.charAt(j);
            char replacement = function.apply(message.charAt(i), keyValue);
            cipherResult.append(replacement);

            j++;
            if (j == key.length()) {
                j = 0;
            }
        }

        return cipherResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        String message;
        String key;
        while (!choice.equals("e") && !choice.equals("d")) {
            System.out.print("Type E if encrypt, type D if decrypt:");
            choice = scanner.nextLine().toLowerCase();
        }

        System.out.print("Enter the message:");
        message = scanner.nextLine();

        System.out.print("Enter the key text:");
        key = scanner.nextLine();

        System.out.println("Result:" + cipher(message, key, choice));

    }

}
