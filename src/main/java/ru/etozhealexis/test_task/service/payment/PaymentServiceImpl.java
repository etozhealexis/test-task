package ru.etozhealexis.test_task.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.etozhealexis.test_task.config.statemachine.event.PaymentEvent;
import ru.etozhealexis.test_task.config.statemachine.state.PaymentState;
import ru.etozhealexis.test_task.model.Payment;
import ru.etozhealexis.test_task.repository.PaymentRepository;
import ru.etozhealexis.test_task.service.ClientBonusService;
import ru.etozhealexis.test_task.service.RefundService;
import ru.etozhealexis.test_task.service.transaction.TransactionService;

import java.math.BigDecimal;
import java.util.Map;

import static ru.etozhealexis.test_task.config.statemachine.state.PaymentState.*;

/**
 * сервис, отвечающий за проведение оплаты
 */

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private StateMachineFactory<PaymentState, PaymentEvent> stateMachineFactory;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private RefundService refundService;
    @Autowired
    private ClientBonusService clientBonusService;
    @Autowired
    private Map<String, TransactionService> transactionServiceMap;

    private final BigDecimal RETURN_SUM = BigDecimal.valueOf(20);
    private final BigDecimal BONUS_SUM = BigDecimal.valueOf(300);
    private final String PAYMENT_ID_HEADER = "payment_id";

    /**
     * метод, выполняющий либо оплату в магазине/онлайн-покупках, либо вызывающий возврат средств
     * @param typeOfPayment - тип покупки
     * @param amount - средства, затраченные на покупку
     */
    public void pay(String typeOfPayment, BigDecimal amount) {
        if (amount.compareTo(RETURN_SUM) > 0) {
            transactionServiceMap.get(typeOfPayment).makeTransaction(amount);
            if (amount.compareTo(BONUS_SUM) > 0) {
                clientBonusService.addBonus(amount);
            }
        } else {
            refundService.refund(amount);
        }
    }

    /**
     * все методы ниже связаны со StateMachine
     * додумать концепт не успел
     */

    @Transactional
    @Override
    public Payment newPayment(Payment payment) {
        payment.setPaymentState(CLIENT);
        return paymentRepository.save(payment);
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> payShop(Long id) {
        StateMachine<PaymentState, PaymentEvent> sm = build(id);

        sendEvent(id, sm, PaymentEvent.SHOP_PAY);

        return sm;
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> payOnline(Long id) {
        StateMachine<PaymentState, PaymentEvent> sm = build(id);

        sendEvent(id, sm, PaymentEvent.ONLINE_PAY);

        return sm;
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> refundOnline(Long id) {
        StateMachine<PaymentState, PaymentEvent> sm = build(id);

        sendEvent(id, sm, PaymentEvent.ONLINE_REFUND);

        return sm;
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> bankCommission(Long id) {
        StateMachine<PaymentState, PaymentEvent> sm = build(id);

        sendEvent(id, sm, PaymentEvent.BANK_COMMISSION);

        return sm;
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> calculateBonusShop(Long id) {
        StateMachine<PaymentState, PaymentEvent> sm = build(id);

        sendEvent(id, sm, PaymentEvent.BANK_BONUS_SHOP);

        return sm;
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> calculateBonusOnline(Long id) {
        StateMachine<PaymentState, PaymentEvent> sm = build(id);

        sendEvent(id, sm, PaymentEvent.BANK_BONUS_ONLINE);

        return sm;
    }

    @Transactional
    @Override
    public StateMachine<PaymentState, PaymentEvent> calculateBonusClient(Long id) {
        StateMachine<PaymentState, PaymentEvent> sm = build(id);

        sendEvent(id, sm, PaymentEvent.BANK_BONUS_CLIENT);

        return sm;
    }

    private void sendEvent(Long id, StateMachine<PaymentState, PaymentEvent> sm, PaymentEvent event) {
        Message<PaymentEvent> message = MessageBuilder.withPayload(event)
                .setHeader(PAYMENT_ID_HEADER, id)
                .build();

        sm.sendEvent(message);
    }

    private StateMachine<PaymentState, PaymentEvent> build(Long id) {
        Payment payment = paymentRepository.getReferenceById(id);

        StateMachine<PaymentState, PaymentEvent> sm = stateMachineFactory.getStateMachine(Long.toString(id));

        sm.stop();

        sm.getStateMachineAccessor()
                .doWithAllRegions(sma -> sma.resetStateMachine(new DefaultStateMachineContext<>(
                        payment.getPaymentState(),
                        null,
                        null,
                        null
                )));

        sm.start();

        return sm;
    }
}
