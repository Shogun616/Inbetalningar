package se.itello.example.payments.payment;

import org.springframework.stereotype.Service;
import se.itello.example.payments.exception.BadRequestException;
import se.itello.example.payments.jms.Receiver;
import se.itello.example.payments.jms.Sender;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentReceiver paymentBundleReceiver;

    public PaymentService(PaymentReceiver paymentBundleReceiver) {
        this.paymentBundleReceiver = paymentBundleReceiver;
    }

    public PaymentBundle startPaymentBundle(PaymentBundle paymentBundle){
        if(paymentBundle.getAccountNumber().isEmpty() || paymentBundle.getPaymentDate() == null ||paymentBundle.getCurrency().isEmpty()){
            throw new BadRequestException("Insufficient data, please fill the required paymentBundle data.");
        }
        paymentBundle.addPayment(paymentBundle.getPayments());
        try {
            Sender.sendPaymentBundle(paymentBundle.getAccountNumber(), paymentBundle.getPaymentDate(), paymentBundle.getCurrency());
        } catch (Exception e){
            e.printStackTrace();
        }
        return paymentBundleReceiver.save(paymentBundle);
    }

    public void endPaymentBundle(Long id){
        PaymentBundle foundPaymentBundle = paymentBundleReceiver.findById(id).orElseThrow(EntityNotFoundException::new);
        try {
            Receiver.receivePaymentBundle();
        } catch (Exception e){
            e.printStackTrace();
        }
        paymentBundleReceiver.deleteById(foundPaymentBundle.getId());
    }

    public Optional<PaymentBundle> findPaymentBundleById(Long id) {
        return paymentBundleReceiver.findById(id);
    }
}