package ru.netology.data;

import lombok.NoArgsConstructor;
import lombok.Value;
import ru.netology.Generator;

import static ru.netology.Generator.getMonth;
import static ru.netology.Generator.getYear;

@NoArgsConstructor
public class Data {

    @Value
    public static class CardData {
        String number;
        String month;
        String year;
        String holder;
        String cvv;
    }

    public static CardData getApprovedCard() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 0), getYear(1, 0), "Ivanov Ivan", "123");
    }

    public static CardData getDeclinedCard() {
        return new CardData("4444 4444 4444 4442", getMonth(0, 0), getYear(1, 0), "Ivanov Ivan", "123");
    }

 //

    public static CardData getInvalidCardNumberIfLess16Sym() {
        return new CardData("4444 4444 4444 4", getMonth(0, 0), getYear(1, 0), "Ivanov Ivan", "123");
    }

    public static CardData getInvalidCardNumberIfOutOfBase() {
        return new CardData("4445 4444 4444 4441", getMonth(0, 0), getYear(1, 0), "Ivanov Ivan", "123");
    }

//

    public static CardData getInvalidNumberOfMonthIfOneSym() {
        return new CardData("4444 4444 4444 4441", "1", getYear(1, 0), "Ivanov Ivan", "123");
    }

    public static CardData getInvalidNumberOfMonthIfMore12() {
        return new CardData("4444 4444 4444 4441", "20", getYear(1, 0), "Ivanov Ivan", "123");
    }

    public static CardData getInvalidNumberOfMonthIfZero() {
        return new CardData("4444 4444 4444 4441", "00", getYear(1, 0), "Ivanov Ivan", "123");
    }
    
    public static CardData getInvalidNumberOfMonthIfLessThenThisMonthInCurrentYear() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 1), getYear(0, 0), "Ivanov Ivan", "123");
    }

 //

    public static CardData getInvalidYearIfBeforeCurrentYear() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 0), getYear(0, 1), "Ivanov Ivan", "123");
    }

    public static CardData getInvalidYearIfZero() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 0), "00", "Ivanov Ivan", "123");
    }

    public static CardData getInvalidYearIfInTheFarFuture() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 0), getYear(6, 0), "Ivanov Ivan", "123");
    }

//

    public static CardData getInvalidCardholderNameIfSpace() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 0), getYear(1, 0), " ", "123");
    }

    public static CardData getInvalidCardholderNameIfOneWord() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 0), getYear(1, 0), "Ivanov", "123");
    }

    public static CardData getInvalidCardholderNameIfThreeWords() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 0), getYear(1, 0), "Ivanov Ivan Petrovich", "123");
    }

    public static CardData getInvalidCardholderNameIfRusSym() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 0), getYear(1, 0), "Иванов Иван", "123");
    }

    public static CardData getInvalidCardholderNameIfNumeric() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 0), getYear(1, 0), "5432 3232", "123");
    }

    public static CardData getInvalidCardholderNameIfWildcard() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 0), getYear(1, 0), "#%№", "123");
    }

//

    public static CardData getInvalidCvvIfTwoSym() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 0), getYear(1, 0), "Ivanov Ivan", "12");
    }

    public static CardData getInvalidCvvIfThreeZero() {
        return new CardData("4444 4444 4444 4441", getMonth(0, 0), getYear(1, 0), "Ivanov Ivan", "000");
    }

    public static CardData getInvalidCardDataIfEmptyAllFields() {
        return new CardData("", "", "", "", "");
    }

}
