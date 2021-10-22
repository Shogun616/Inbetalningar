package payment;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.itello.example.payments.Main;
import se.itello.example.payments.payment.PaymentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileSavingTest {
   static List<Payment> payments;

    @Test
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test is starting");
        payments = new ArrayList<>();
    }

    @Test
    @DisplayName("testing saving file call")
    public void testSavingToFile() {
        Payment p = new Payment();
        payments.add(p);
        assertEquals("", PaymentService.fileSaving(payments));

        assertEquals(2,PaymentService.class.getDeclaredFields().length);
    }

    @Test
    @DisplayName(" number of constructor")
    public void TestMainClass() throws IOException {
        assertEquals(1, Main.class.getConstructors().length);
    }

    @Test
    @DisplayName("test if file exist")
    public void testIfFileExist(){
        assertTrue(PaymentService.fileSaving.exist);
    }

    @Test
    @AfterAll
    public static void afterAll(){
        System.out.println("Test is completed");

    }

}