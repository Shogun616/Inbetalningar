package se.itello.example.payments.payment;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {

    private String accountNumber;
    private Date paymentDate;
    private String currency;
    private BigDecimal amount;
    private String reference;

    public Payment(String accountNumber, Date paymentDate, String currency, BigDecimal amount, String reference) {
        this.accountNumber = accountNumber;
        this.paymentDate = paymentDate;
        this.currency = currency;
        this.amount = amount;
        this.reference = reference;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
}
