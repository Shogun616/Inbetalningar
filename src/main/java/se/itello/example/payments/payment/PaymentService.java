package se.itello.example.payments.payment;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaymentService{

    static File file = new File("_betalningsservice.txt" + "_inbetalningstjänst.txt");
    static boolean exist = file.exists();

    public static String fileSaving(List<PaymentReceiver> payment){

        List<PaymentReceiver> payments = new ArrayList<>();
        payments = payment;
        System.out.println("printing list");
        for (PaymentReceiver pay : payments)
            System.out.println(pay);

        try {
            addPaymentToFile(payments, file);
        } catch (FileNotFoundException e) {
            System.out.println("file is not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void addPaymentToFile(List<PaymentReceiver> payment, File filename) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (int i = 0; i < payment.size(); i++) {

            if (payment.get(i) != null) {
                objectOutputStream.writeObject(payment.get(i).toString());
                System.out.println("\n");
                System.out.println("Payment successfully add to file");
            } else
                System.out.println("Payment already exists");
            objectOutputStream.close();

        }
    }
}
