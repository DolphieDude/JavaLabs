package lab5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task5_4 {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<WeatherInfo> weatherInfos = new ArrayList<>();
        newWeatherInfo(weatherInfos);
        while(true) {
            System.out.println("List of forecasts");
            for (int i = 0; i < weatherInfos.size(); i++) {
                System.out.println(i + "=" + weatherInfos.get(i).getUploadDate());
            }

            String input;
            System.out.println("New or print? ");
            loop:
            while(true) {
                input = scanner.nextLine().toLowerCase();
                switch (input) {
                    case "new":
                        newWeatherInfo(weatherInfos);
                        break loop;
                    case "print":
                        printWeatherInfo(weatherInfos);
                        break loop;
                    case "quit":
                        return;
                }
                System.out.println("Wrong input");
            }
        }


    }

    private static void newWeatherInfo(ArrayList<WeatherInfo> weatherInfos) {
        String directionOfWind;
        byte speedOfWindKmH, temperatureCelsius, precipitation, humidity;

        System.out.println("Adding new forecast info:");
        System.out.print("Direction of wind=");
        while(true) {
            try {
                directionOfWind = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Wrong input");
            }
        }

        System.out.print("Speed of wind(Km/H)=");
        speedOfWindKmH = byteInputLoop(true, false);
        System.out.print("Temperature(Celsius)=");
        temperatureCelsius = byteInputLoop(false, false);
        System.out.print("Precipitation=");
        precipitation = byteInputLoop(true, true);
        System.out.print("Humidity=");
        humidity = byteInputLoop(true, true);

        weatherInfos.add(new WeatherInfo(directionOfWind, speedOfWindKmH, temperatureCelsius, precipitation, humidity));

    }

    private static byte byteInputLoop(boolean doesNeedAbs, boolean isPercentage) {
        String input;
        byte result;
        while(true) {
            try {
                input = scanner.nextLine();
                result = Byte.parseByte(input);
                if (isPercentage && result > 100) {
                    throw new InputMismatchException();
                }
                if (doesNeedAbs && result < 0) {
                    result = (byte) (-1 * result);
                }
                break;
            } catch (Exception e) {
                System.out.println("Wrong input");
            }
        }

        return result;
    }

    private static void printWeatherInfo(ArrayList<WeatherInfo> weatherInfos) {
        System.out.println("Which forecast do you want to see? ");
        int index;
        while(true) {
            try {
                index = scanner.nextInt();
                System.out.println(weatherInfos.get(index));
                break;
            } catch (Exception e) {
                System.out.println("Wrong input");
            }
        }
    }
}
