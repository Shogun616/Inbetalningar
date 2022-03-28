package se.itello.example.payments.payment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface PaymentReceiver extends CrudRepository<Payment, Long> {
    /**
     * Called to mark the start of a new payment bundle.
     * @param accountNumber The account number where funds are deposited.
     * @param paymentDate The date at which the funds were/will be deposited on the specified account.
     * @param currency The currency of the payments in the bundle.
     */
    PaymentBundle startPaymentBundle(String accountNumber, Date paymentDate, String currency);

    /**
     * Called to notify the receiver of a single payment within a bundle.
     * @param amount The payment amount.
     * @param reference The payment reference.
     */
    Payment payment(BigDecimal amount, String reference);

    /**
     * Called to mark the end of a payment bundle. This means that there will be no more calls to payment()
     * for this bundle, and that the receiver can process the bundle.
     */
    void endPaymentBundle();
}
