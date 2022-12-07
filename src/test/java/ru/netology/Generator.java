package ru.netology;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Generator {

    public static String getMonth(int plusMonth, int minusMonth) {
        return LocalDate.now().minusMonths(minusMonth).plusMonths(plusMonth).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getYear(int plusYear, int minusYear) {
        return LocalDate.now().minusYears(minusYear).plusYears(plusYear).format(DateTimeFormatter.ofPattern("yy"));
    }
}
