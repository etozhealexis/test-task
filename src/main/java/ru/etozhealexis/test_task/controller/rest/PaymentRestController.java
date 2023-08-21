package ru.etozhealexis.test_task.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.etozhealexis.test_task.service.payment.PaymentService;

import java.math.BigDecimal;

/**
 * rest-контроллер для оплаты покупок
 */

@RestController
@RequestMapping("/api/payment")
public class PaymentRestController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{typeOfPayment}/{amount}")
    public void pay(@PathVariable String typeOfPayment,
                    @PathVariable BigDecimal amount) {
        paymentService.pay(typeOfPayment, amount);
    }
}
