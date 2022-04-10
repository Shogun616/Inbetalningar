package se.itello.example.payments.jms;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class Sender {

    public static void sendPaymentBundle(String accountNumber, Date paymentDate, String currency) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setPort(5672);
        factory.setHost("RabbitMqManager");

        try(Connection connection = factory.newConnection()) {

            Channel channel = connection.createChannel();
            String QUEUE_NAME = "paymentData";
            channel.queueDeclare(QUEUE_NAME, false, false, false,  null);
            String message = accountNumber + ", " + paymentDate + ", "  + currency + ", " + ", " + LocalDateTime.now();
            System.out.println("======> Transmitting this message:  " + message);

            channel.basicPublish("", QUEUE_NAME,null, message.getBytes(StandardCharsets.UTF_8));
        }
    }
}