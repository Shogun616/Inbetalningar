package se.itello.example.payments.payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentBundleReceiver paymentBundleReceiver;
    private final PaymentReceiver paymentReceiver;

    public PaymentService(PaymentBundleReceiver paymentBundleReceiver, PaymentReceiver paymentReceiver) {
        this.paymentBundleReceiver = paymentBundleReceiver;
        this.paymentReceiver = paymentReceiver;
    }

    public PaymentBundle startPaymentBundle(PaymentBundle paymentBundle){
        return paymentBundleReceiver.save(paymentBundle);
    }

    public Payment payment(Payment payment){
        return paymentReceiver.save(payment);
    }
}