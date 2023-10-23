package lab2;

import java.util.HashMap;

public class Task2_25 {
    public static int getDayOfYearOfDate(String[] args) {
        int dayOfMonth;
        int month;
        boolean isLeapYear;
        try {
            dayOfMonth = Integer.parseInt(args[0]);
            month = Integer.parseInt(args[1]);
            if (month > 12) {
                throw new Exception();
            }
            isLeapYear = Boolean.parseBoolean(args[2]);
        } catch (Exception e) {
            throw new IllegalArgumentException("args must be parseable to int");
        }

        int additionalDay = isLeapYear ? 1 : 0;
        HashMap<Integer, Integer> mapOfMonths = new HashMap<>();
        mapOfMonths.put(1, 0);
        mapOfMonths.put(2, 31);
        mapOfMonths.put(3, 59 + additionalDay);
        mapOfMonths.put(4, 90 + additionalDay);
        mapOfMonths.put(5, 120 + additionalDay);
        mapOfMonths.put(6, 151 + additionalDay);
        mapOfMonths.put(7, 181 + additionalDay);
        mapOfMonths.put(8, 212 + additionalDay);
        mapOfMonths.put(9, 243 + additionalDay);
        mapOfMonths.put(10, 273 + additionalDay);
        mapOfMonths.put(11, 314 + additionalDay);
        mapOfMonths.put(12, 334 + additionalDay);
        mapOfMonths.put(13, 365 + additionalDay);

        int dayOfYear;
        dayOfYear = dayOfMonth + mapOfMonths.get(month);
        if (dayOfYear > mapOfMonths.get(month + 1)) {
            throw new IllegalArgumentException("Day is not real for this month");
        }


        System.out.println("Day of the year: " + dayOfYear);
        return dayOfYear;
    }
}
