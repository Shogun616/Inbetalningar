package se.itello.example.payments.payment;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class PaymentService{

private final PaymentReceiver paymentReceiver;

    public PaymentService(PaymentReceiver paymentReceiver) {
        this.paymentReceiver = paymentReceiver;
    }

    public void startPaymentBundle(String accountNumber, Date paymentDate, String currency){
        paymentReceiver.startPaymentBundle(accountNumber, paymentDate, currency);
    }

    public void payment(BigDecimal amount, String reference){
        paymentReceiver.payment(amount, reference);
    }

    public void endPaymentBundle(){
        paymentReceiver.endPaymentBundle();
    }
}
