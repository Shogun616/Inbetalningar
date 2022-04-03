package se.itello.example.payments.payment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("startPaymentBundle")
    public ResponseEntity<PaymentBundle> startPaymentBundle(@RequestBody PaymentBundle paymentBundle){
        PaymentBundle addPaymentBundle = paymentService.startPaymentBundle(paymentBundle);
        return new ResponseEntity<>(addPaymentBundle, HttpStatus.CREATED);
    }

    @PostMapping("payment")
    public ResponseEntity<Payment> startPaymentBundle(@RequestBody Payment payment){
        Payment addPayment = paymentService.payment(payment);
        return new ResponseEntity<>(addPayment, HttpStatus.CREATED);
    }
}
