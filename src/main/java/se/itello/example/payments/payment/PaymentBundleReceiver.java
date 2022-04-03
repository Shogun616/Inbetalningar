package se.itello.example.payments.payment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.itello.example.payments.payment.PaymentBundle;

@Repository
public interface PaymentBundleReceiver extends CrudRepository<PaymentBundle, Long> {
}
