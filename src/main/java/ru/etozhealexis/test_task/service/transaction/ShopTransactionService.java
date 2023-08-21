package ru.etozhealexis.test_task.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.etozhealexis.test_task.config.dbentity.ClientConfig;
import ru.etozhealexis.test_task.service.BankAccountService;
import ru.etozhealexis.test_task.service.ClientService;

import java.math.BigDecimal;

/**
 * класс, который совершает транзакцию при покупке
 * в магазине
 */

@Service("Shop")
public class ShopTransactionService implements TransactionService {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientConfig clientConfig;
    @Autowired
    private BankAccountService bankAccountService;

    private final BigDecimal BONUS = BigDecimal.valueOf(0.1);

    @Override
    public void makeTransaction(BigDecimal amount) {
        clientService.subtractMoney(clientConfig.getId(), amount);
        bankAccountService.updateShopBonus(amount.multiply(BONUS));
    }
}
