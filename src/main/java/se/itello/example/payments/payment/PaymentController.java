package se.itello.example.payments.payment;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("api/v1/")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

//    @PostMapping("/startPaymentBundle")
//    public void startPaymentBundle(@RequestBody String accountNumber, Date paymentDate, String currency){
//        paymentService.startPaymentBundle(accountNumber, paymentDate, currency);
//        paymentService.endPaymentBundle();
//    }
//
//    @PostMapping("/payment")
//    public void payment(@RequestBody BigDecimal amount, String reference){
//        paymentService.payment(amount, reference);
//        paymentService.endPaymentBundle();
//    }
}
