package lab2;

import java.util.Scanner;

//FOR SHOWCASE OF THE FUNCTIONALITY
public class Lab2Main {
    public static void main(String[] args) {
        //Task2_24
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputFor2_25 = input.split(" ");
        Task2_24.getDayOfYearOfDate(inputFor2_25);
    }
}
