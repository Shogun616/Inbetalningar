package se.itello.example.payments.payment;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class PaymentService{

    private final PaymentReceiver paymentReceiver;

    public PaymentService(PaymentReceiver paymentReceiver) {
        this.paymentReceiver = paymentReceiver;
    }

    public PaymentBundle startPaymentBundle(String accountNumber, Date paymentDate, String currency){
        return paymentReceiver.startPaymentBundle(accountNumber, paymentDate, currency);
    }

    public Payment payment(BigDecimal amount, String reference){
        return paymentReceiver.payment(amount, reference);
    }

    public void endPaymentBundle(){
        paymentReceiver.endPaymentBundle();
    }
}