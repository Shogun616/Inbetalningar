package se.itello.example.payments.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;


@RestController
@RequestMapping("")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("")
    public void startPaymentBundle(@PathVariable String accountNumber, Date paymentDate, String currency){
        paymentService.startPaymentBundle(accountNumber, paymentDate, currency);
    }


    public void payment(@PathVariable BigDecimal amount, String reference){
        paymentService.payment(amount, reference);
    }

    public void endPaymentBundle(){
        paymentService.endPaymentBundle();
    }
}
