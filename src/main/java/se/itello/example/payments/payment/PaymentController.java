package se.itello.example.payments.payment;

import se.itello.example.payments.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/startPaymentBundle")
    public ResponseEntity<PaymentBundle> startPaymentBundle(@RequestBody PaymentBundle paymentBundle){
        PaymentBundle addPaymentBundle = paymentService.startPaymentBundle(paymentBundle);
        return new ResponseEntity<>(addPaymentBundle, HttpStatus.CREATED);
    }

    @DeleteMapping("/endPaymentBundle/{id}")
    public ResponseEntity<Void> endPaymentBundle(@PathVariable Long id) {
        Optional<PaymentBundle> foundPaymentBundle = paymentService.findPaymentBundleById(id);
        if (!foundPaymentBundle.isPresent()){
            throw new NotFoundException("No data available of paymentBundle with ID: " + id);
        }
        paymentService.endPaymentBundle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
