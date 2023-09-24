package lab1;

public class Task1_20 {
    public static void main(String[] args) {
        String str = args[0];
        int num;
        try {
            num = Integer.parseInt(args[0]);
        }
        catch (Exception e) {
            System.out.println("Not integer");
            return;
        }

        if (str.contains("-") || str.length() != 4) {
            System.out.println("Number must be positive and have 4 digits");
            return;
        }

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1) result = str.charAt(i) + result;
            else result += str.charAt(i);
        }
        System.out.println("Shifted number = " + result);

        System.out.println("Logarithm of number = " + Math.log(num));
    }
}
