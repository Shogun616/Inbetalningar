package se.itello.example.payments;

import se.itello.example.payments.payment.PaymentService;

import java.math.BigDecimal;
import java.util.Date;

public class Main {

    public static void main(String[] args){
        PaymentService.buildPaymentBundle("555-5643 09 767", new Date(2010-9-12), "758 SEK");

        PaymentService.payment(new BigDecimal("30000000000000010300000000000000000000009876543210"),
                "00000000001234123456789700000000000000000000000000000000000000000000000000000000");
    }
}