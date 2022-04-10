package se.itello.example.payments.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal amount;
    private String reference;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.EAGER, targetEntity = PaymentBundle.class)
    private PaymentBundle paymentBundles;

    public Payment(BigDecimal amount, String reference) {
        this.amount = amount;
        this.reference = reference;
    }

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public PaymentBundle getPaymentBundles() {
        return paymentBundles;
    }

    public void setPaymentBundles(PaymentBundle paymentBundles) {
        this.paymentBundles = paymentBundles;
    }
}
