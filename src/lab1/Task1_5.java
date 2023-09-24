package lab1;
public class Task1_5 {
    public static void main(String[] args) {
        double a, b, c;
        a = Double.parseDouble(args[0]);
        b = Double.parseDouble(args[1]);
        c = Double.parseDouble(args[2]);

        double semiPerimeter = (a + b + c) / 2.;

        double area =   Math.sqrt(semiPerimeter * (semiPerimeter - a) *
                (semiPerimeter - b) * (semiPerimeter - c));

        System.out.println("Area is " + area);
        System.out.println("Semi Perimeter is " + semiPerimeter);
    }
}