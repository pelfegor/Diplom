package ru.netology.tests.payment;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.SQL;
import ru.netology.databaseentities.OrderEntity;
import ru.netology.databaseentities.PaymentEntity;
import ru.netology.pages.MainPage;
import ru.netology.pages.PaymentPage;
import ru.netology.tests.TestBaseUI;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.data.Data.getApprovedCard;

public class PayHappyPathTest extends TestBaseUI {

    MainPage mainPage = new MainPage();
    PaymentPage paymentPage = new PaymentPage();

    @BeforeEach
    void setUpForPayWithCard() {
        mainPage.payWithCard();
    }
    static List<PaymentEntity> payments = SQL.getPayments();
    static List<OrderEntity> orders = SQL.getOrders();

    @Test
    public void shouldSuccessPayIfValidApprovedCards() {
        val cardData = getApprovedCard();
        paymentPage.fillCardData(cardData);
        paymentPage.shouldSuccessNotification();

        payments = SQL.getPayments();
        orders = SQL.getOrders();

        val expectedStatus = "APPROVED";
        val actualStatus = payments.get(0).getStatus();
        assertTrue(actualStatus.equalsIgnoreCase(expectedStatus));

        val expectedAmount = "4500000";
        val actualAmount = payments.get(0).getAmount();
        assertEquals(expectedAmount, actualAmount);

        val transactionIdExpected = payments.get(0).getTransaction_id();
        val paymentIdActual = orders.get(0).getPayment_id();
        assertNotNull(transactionIdExpected);
        assertNotNull(paymentIdActual);
        assertEquals(transactionIdExpected, paymentIdActual);
    }
}
