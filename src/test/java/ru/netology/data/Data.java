package ru.netology.data;

import lombok.NoArgsConstructor;
import lombok.Value;

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
        return new CardData("4444 4444 4444 4441", "09", "24", "Ivanov Ivan", "123");
    }

    public static CardData getDeclinedCard() {
        return new CardData("4444 4444 4444 4442", "09", "24", "Ivanov Ivan", "123");
    }

 //

    public static CardData getInvalidCardNumberIfLess16Sym() {
        return new CardData("4444 4444 4444 4", "09", "24", "Ivanov Ivan", "123");
    }

    public static CardData getInvalidCardNumberIfOutOfBase() {
        return new CardData("4445 4444 4444 4441", "09", "24", "Ivanov Ivan", "123");
    }

//

    public static CardData getInvalidNumberOfMonthIfOneSym() {
        return new CardData("4444 4444 4444 4441", "1", "24", "Ivanov Ivan", "123");
    }

    public static CardData getInvalidNumberOfMonthIfMore12() {
        return new CardData("4444 4444 4444 4441", "20", "24", "Ivanov Ivan", "123");
    }

    public static CardData getInvalidNumberOfMonthIfZero() {
        return new CardData("4444 4444 4444 4441", "00", "24", "Ivanov Ivan", "123");
    }

 //

    public static CardData getInvalidYearIfBeforeCurrentYear() {
        return new CardData("4444 4444 4444 4441", "09", "19", "Ivanov Ivan", "123");
    }

    public static CardData getInvalidYearIfZero() {
        return new CardData("4444 4444 4444 4441", "09", "00", "Ivanov Ivan", "123");
    }

    public static CardData getInvalidYearIfInTheFarFuture() {
        return new CardData("4444 4444 4444 4441", "09", "40", "Ivanov Ivan", "123");
    }

//

    public static CardData getInvalidCardholderNameIfSpace() {
        return new CardData("4444 4444 4444 4441", "09", "24", " ", "123");
    }

    public static CardData getInvalidCardholderNameIfOneWord() {
        return new CardData("4444 4444 4444 4441", "09", "24", "Ivanov", "123");
    }

    public static CardData getInvalidCardholderNameIfThreeWords() {
        return new CardData("4444 4444 4444 4441", "09", "24", "Ivanov Ivan Petrovich", "123");
    }

    public static CardData getInvalidCardholderNameIfRusSym() {
        return new CardData("4444 4444 4444 4441", "09", "24", "Иванов Иван", "123");
    }

    public static CardData getInvalidCardholderNameIfNumeric() {
        return new CardData("4444 4444 4444 4441", "09", "24", "5432 3232", "123");
    }

    public static CardData getInvalidCardholderNameIfWildcard() {
        return new CardData("4444 4444 4444 4441", "09", "24", "#%№", "123");
    }

//

    public static CardData getInvalidCvvIfTwoSym() {
        return new CardData("4444 4444 4444 4441", "09", "24", "Ivanov Ivan", "12");
    }

    public static CardData getInvalidCvvIfThreeZero() {
        return new CardData("4444 4444 4444 4441", "09", "24", "Ivanov Ivan", "000");
    }

    public static CardData getInvalidCardDataIfEmptyAllFields() {
        return new CardData("", "", "", "", "");
    }

}
