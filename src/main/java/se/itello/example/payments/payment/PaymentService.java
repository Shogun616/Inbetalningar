package se.itello.example.payments.payment;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentService{

    public static void buildPaymentBundle(String accountNumber, Date paymentDate, String currency){
        try {
            FileWriter writer = new FileWriter("_betalningsservice.txt");
            writer.write("555-5643 09 767");
            writer.write("2010-9-12");
            writer.write("758 SEK");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void payment(BigDecimal amount, String reference){
        try {
            FileWriter writer1 = new FileWriter("_inbetalningstjänst.txt");
            writer1.write("30000000000000010300000000000000000000009876543210 ");
            writer1.write("00000000001234123456789700000000000000000000000000000000000000000000000000000000");
            writer1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
