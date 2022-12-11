package ru.netology.data;

import lombok.NoArgsConstructor;
import lombok.Value;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@NoArgsConstructor
public class Data {

    static Faker faker = new Faker(new Locale("en", "EN"));

    @Value
    public static class CardData {
        String number;
        String month;
        String year;
        String holder;
        String cvv;
    }

    public static CardData getDeclinedCard() {
        return new CardData(getInvalidCard(), getMonth(0, 0), getYear(1, 0), getValidName(), getValidCvv());
    }

 //

    public static CardData getInvalidCardNumberIfLess16Sym() {
        return new CardData(getCardLess16Sym(), getMonth(0, 0), getYear(1, 0), getValidName(), getValidCvv());
    }

    public static CardData getInvalidCardNumberIfOutOfBase() {
        return new CardData(getValidCard(), getMonth(0, 0), getYear(1, 0), getValidName(), getValidCvv());
    }

//

    public static CardData getInvalidNumberOfMonthIfOneSym() {
        return new CardData(getValidCard(), "1", getYear(1, 0), getValidName(), getValidCvv());
    }

    public static CardData getInvalidNumberOfMonthIfMore12() {
        return new CardData(getValidCard(), "20", getYear(1, 0), getValidName(), getValidCvv());
    }

    public static CardData getInvalidNumberOfMonthIfZero() {
        return new CardData(getValidCard(), "00", getYear(1, 0), getValidName(), getValidCvv());
    }
    
    public static CardData getInvalidNumberOfMonthIfLessThenThisMonthInCurrentYear() {
        return new CardData(getValidCard(), getMonth(0, 1), getYear(0, 0), getValidName(), getValidCvv());
    }

 //

    public static CardData getInvalidYearIfBeforeCurrentYear() {
        return new CardData(getValidCard(), getMonth(0, 0), getYear(0, 1), getValidName(), getValidCvv());
    }

    public static CardData getInvalidYearIfZero() {
        return new CardData(getValidCard(), getMonth(0, 0), "00", getValidName(), getValidCvv());
    }

    public static CardData getInvalidYearIfInTheFarFuture() {
        return new CardData(getValidCard(), getMonth(0, 0), getYear(6, 0), getValidName(), getValidCvv());
    }

//

    public static CardData getInvalidCardholderNameIfSpace() {
        return new CardData(getValidCard(), getMonth(0, 0), getYear(1, 0), " ", getValidCvv());
    }

    public static CardData getInvalidCardholderNameIfOneWord() {
        return new CardData(getValidCard(), getMonth(0, 0), getYear(1, 0), getOneName(), getValidCvv());
    }

    public static CardData getInvalidCardholderNameIfThreeWords() {
        return new CardData(getValidCard(), getMonth(0, 0), getYear(1, 0), getFullName(), getValidCvv());
    }

    public static CardData getInvalidCardholderNameIfRusSym() {
        return new CardData(getValidCard(), getMonth(0, 0), getYear(1, 0), getRusName(), getValidCvv());
    }

    public static CardData getInvalidCardholderNameIfNumeric() {
        return new CardData(getValidCard(), getMonth(0, 0), getYear(1, 0), "5432 3232", getValidCvv());
    }

    public static CardData getInvalidCardholderNameIfWildcard() {
        return new CardData(getValidCard(), getMonth(0, 0), getYear(1, 0), "#%№", getValidCvv());
    }

//

    public static CardData getInvalidCvvIfTwoSym() {
        return new CardData(getValidCard(), getMonth(0, 0), getYear(1, 0), getValidName(), "12");
    }

    public static CardData getInvalidCvvIfThreeZero() {
        return new CardData(getValidCard(), getMonth(0, 0), getYear(1, 0), getValidName(), "000");
    }

    public static CardData getInvalidCardDataIfEmptyAllFields() {
        return new CardData("", "", "", "", "");
    }

    public static String getValidName() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getValidCvv() {
        return faker.regexify("\\d{3}");
    }

    public static String getValidCard() {
        return "4444 4444 4444 4441";
    }

    public static String getInvalidCard() {
        return "4444 4444 4444 4442";
    }

    public static String getCardLess16Sym() {
        return "4444 4444 4444 444";
    }

    public static CardData getApprovedCard() {
        return new CardData(getValidCard(), getMonth(0, 0), getYear(1, 0), getValidName(), getValidCvv());
    }

    public static String getOneName() {
        return faker.name().firstName();
    }

    public static String getFullName() {
        return faker.name().nameWithMiddle();
    }

    public static String getRusName() {
        Faker faker = new Faker(new Locale("ru", "RU"));
        return faker.name().firstName() + faker.name().lastName();
    }

    public static String getMonth(int plusMonth, int minusMonth) {
        return LocalDate.now().minusMonths(minusMonth).plusMonths(plusMonth).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getYear(int plusYear, int minusYear) {
        return LocalDate.now().minusYears(minusYear).plusYears(plusYear).format(DateTimeFormatter.ofPattern("yy"));
    }
}
