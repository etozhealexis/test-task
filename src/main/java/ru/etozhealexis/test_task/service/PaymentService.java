package ru.etozhealexis.test_task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.etozhealexis.test_task.service.transaction.TransactionService;

import java.math.BigDecimal;
import java.util.Map;

/**
 * сервис, отвечающий за проведение оплаты
 */

@Service
public class PaymentService {
    @Autowired
    private ReturnService returnService;
    @Autowired
    private ClientBonusService clientBonusService;
    @Autowired
    private Map<String, TransactionService> transactionServiceMap;

    private final BigDecimal RETURN_SUM = BigDecimal.valueOf(20);
    private final BigDecimal BONUS_SUM = BigDecimal.valueOf(300);

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
            returnService.returnMoney(amount);
        }
    }
}
