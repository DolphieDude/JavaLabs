package lab1;
public class Task1_10 {
    public static void main(String[] args) {
        double a, b, c;
        try {
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);
        }
        catch (Exception e) {
            System.out.println("Not doubles");
            return;
        }
        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0");

        if (a == 0.) {
            double result;
            if (b == 0.) {
                result = c;
            } else {
                result = -c / b;
            }
            System.out.println("Root is " + result);
            return;
        }


        double d = b * b - 4. * a * c;
        System.out.println(d);
        if (d > 0.) {
            double r1 = (-b + Math.pow(d, 0.5)) / (2. * a);
            double r2 = (-b - Math.pow(d, 0.5)) / (2. * a);
            System.out.println("x1 = " + r1 + "\nx2 = " + r2);
        }
        else if (d == 0.) {
            double r1 = -b / (2. * a);
            System.out.println("x = " + r1);
        }
        else {
            System.out.println("No roots");
        }
    }
}
