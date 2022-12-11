package ru.netology.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import ru.netology.databaseentities.CreditRequestEntity;
import ru.netology.databaseentities.OrderEntity;
import ru.netology.databaseentities.PaymentEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class SQL {
    private static final String url = System.getProperty("db.url");
    private static final String user = System.getProperty("db.user");
    private static final String password = System.getProperty("db.password");
    private static Connection connection;

    @SneakyThrows
    private static Connection getConnection(){
        return DriverManager.getConnection(url, user, password);
    }

    @SneakyThrows
    public static void dropDataBase() {
        val connection = getConnection();
        val runner = new QueryRunner();
        runner.execute(connection, "DELETE FROM credit_request_entity");
        runner.execute(connection, "DELETE FROM order_entity");
        runner.execute(connection, "DELETE FROM payment_entity");
    }

    @SneakyThrows
    public static List<PaymentEntity> getPayments() {
        val connection = getConnection();
        val runner = new QueryRunner();
        var sqlQuery = "SELECT * FROM payment_entity ORDER BY created DESC;";
        ResultSetHandler<List<PaymentEntity>> resultHandler = new BeanListHandler<>(PaymentEntity.class);
        return runner.query(connection, sqlQuery, resultHandler);
    }

    @SneakyThrows
    public static List<CreditRequestEntity> getCreditsRequest() {
        val connection = getConnection();
        val runner = new QueryRunner();
        var sqlQuery = "SELECT * FROM credit_request_entity ORDER BY created DESC;";
        ResultSetHandler<List<CreditRequestEntity>> resultHandler = new BeanListHandler<>(CreditRequestEntity.class);
        return runner.query(connection, sqlQuery, resultHandler);
    }

    @SneakyThrows
    public static List<OrderEntity> getOrders() {
        val connection = getConnection();
        val runner = new QueryRunner();
        var sqlQuery = "SELECT * FROM order_entity ORDER BY created DESC;";
        ResultSetHandler<List<OrderEntity>> resultHandler = new BeanListHandler<>(OrderEntity.class);
        return runner.query(connection, sqlQuery, resultHandler);
    }

    /*public static String getCardStatusForPayment() {
        String statusQuery = "SELECT * FROM payment_entity";
        val runner = new QueryRunner();
        try (Connection connection = getConnection()) {
            val cardStatus = runner.query(connection, statusQuery, new BeanHandler<>(PaymentEntity.class));
            return cardStatus.getStatus();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public static String getPaymentIdForCardPay() {
        val idQueryForCardPay = "SELECT * FROM order_entity";
        val runner = new QueryRunner();
        try (val connection = getConnection()) {
            val paymentId = runner.query(connection, idQueryForCardPay, new BeanHandler<>(OrderEntity.class));
            return paymentId.getPayment_id();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTransactionId() {
        val runner = new QueryRunner();
        String idTransactionQuery = "SELECT * FROM payment_entity";
        try (Connection connection = getConnection()) {
            val transactionId = runner.query(connection, idTransactionQuery, new BeanHandler<>(PaymentEntity.class));
            return transactionId.getTransaction_id();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public static String getAmountPayment() {
        val runner = new QueryRunner();
        String amountQuery = "SELECT * FROM payment_entity";
        try (Connection connection = getConnection()) {
            val transactionId = runner.query(connection, amountQuery, new BeanHandler<>(PaymentEntity.class));
            return transactionId.getAmount();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }*/
}
