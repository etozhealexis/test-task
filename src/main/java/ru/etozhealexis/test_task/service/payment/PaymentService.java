package ru.etozhealexis.test_task.service.payment;

import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;
import ru.etozhealexis.test_task.config.statemachine.event.PaymentEvent;
import ru.etozhealexis.test_task.config.statemachine.state.PaymentState;
import ru.etozhealexis.test_task.model.Payment;

import java.math.BigDecimal;

@Service
public interface PaymentService {

    Payment newPayment(Payment payment);

    void pay(String typeOfPayment, BigDecimal amount);

    StateMachine<PaymentState, PaymentEvent> payShop(Long id);

    StateMachine<PaymentState, PaymentEvent> payOnline(Long id);

    StateMachine<PaymentState, PaymentEvent> refundOnline(Long id);

    StateMachine<PaymentState, PaymentEvent> bankCommission(Long id);

    StateMachine<PaymentState, PaymentEvent> calculateBonusShop(Long id);

    StateMachine<PaymentState, PaymentEvent> calculateBonusOnline(Long id);

    StateMachine<PaymentState, PaymentEvent> calculateBonusClient(Long id);
}
