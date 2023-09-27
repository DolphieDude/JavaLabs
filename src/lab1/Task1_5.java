package lab1;
//Дані довжини сторін трикутника. Знайдіть його площу і напівпериметр.
public class Task1_5 {
    public static void main(String[] args) {
        double a, b, c;
        try {
            a = Math.abs(Double.parseDouble(args[0]));
            b = Math.abs(Double.parseDouble(args[1]));
            c = Math.abs(Double.parseDouble(args[2]));
        }
        catch (Exception e) {
            System.out.println("Not doubles");
            return;
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Triangle is not valid");
            return;
        }

        double semiPerimeter = (a + b + c) / 2.;

        double area =   Math.sqrt(semiPerimeter * (semiPerimeter - a) *
                (semiPerimeter - b) * (semiPerimeter - c));

        System.out.printf("Area is %.1f\n", area);
        System.out.printf("Semi Perimeter is %.1f\n", semiPerimeter);
    }
}