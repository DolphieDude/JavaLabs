/*
Аналіз аргументів, що задаються під час запуску програми. Програма визначає,
які символи містяться у введених аргументах (наприклад, аргументи "abc", "cf", "bfc" містять символи "abcf").
Шаблон аргументу: рядок або латинських букв, або букв кирилиці. Програма виводить кількість заданих аргументів,
значення аргументів і рядок символів, що містяться в аргументах.
 */

package lab3;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3_26 {
    public static void main(String[] args) {
        System.out.println("There are " + args.length + " arguments");
        System.out.println("The arguments:" +  Arrays.toString(args));

        Pattern pattern = Pattern.compile("[A-Za-z]"); //[a-zA-Zа-яА-я] == \\p{L}
        Matcher matcher;
        StringBuilder symbols = new StringBuilder();

        for (String arg: args) {
            for (char character: arg.toCharArray()) {
                String letter = String.valueOf(character);
                matcher = pattern.matcher(letter);

                if (matcher.find() && symbols.indexOf(letter) == -1) {
                    symbols.append(letter);
                }
            }
        }

        System.out.print("Characters:" + symbols);

    }
}
