package lab1;
//Дана сторона ромба і (в градусах) кут при вершині. Знайти площу.
public class Task1_15 {
    public static void main(String[] args) {
        double side, angle;
        try {
            side = Math.abs(Double.parseDouble(args[0]));
            angle = Math.abs(Double.parseDouble(args[1]));
        }
        catch (Exception e) {
            System.out.println("Not doubles");
            return;
        }

        if (angle >= 180.) {
            System.out.println("Rhombus is not valid");
            return;
        }

        double area = Math.pow(side, 2.) * Math.sin(Math.toRadians(angle));

        System.out.printf("Area is %.1f\n", area);
    }
}
