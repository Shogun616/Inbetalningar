package se.itello.example.payments.payment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentReceiver extends CrudRepository<PaymentBundle, Long> {
}
