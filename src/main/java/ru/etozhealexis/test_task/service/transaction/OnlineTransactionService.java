package ru.etozhealexis.test_task.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.etozhealexis.test_task.config.ClientConfig;
import ru.etozhealexis.test_task.service.BankAccountService;
import ru.etozhealexis.test_task.service.ClientService;

import java.math.BigDecimal;

/**
 * класс, который совершает транзакцию при покупке
 * в онлайн-покупках
 */

@Service("Online")
public class OnlineTransactionService implements TransactionService {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientConfig clientConfig;
    @Autowired
    private BankAccountService bankAccountService;

    private final BigDecimal BONUS = BigDecimal.valueOf(0.17);

    @Override
    public void makeTransaction(BigDecimal amount) {
        clientService.subtractMoney(clientConfig.getId(), amount);
        bankAccountService.updateOnlineBonus(amount.multiply(BONUS));
    }
}
