package ru.etozhealexis.test_task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.etozhealexis.test_task.config.ClientConfig;

import java.math.BigDecimal;

/**
 * сервис, отвечающий за возврат средств клиенту
 */

@Service
public class ReturnService {
    @Autowired
    private ClientService clientService;
    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private ClientConfig clientConfig;

    private final BigDecimal COMMISSION = BigDecimal.valueOf(0.1);

    public void returnMoney(BigDecimal amount) {
        BigDecimal bankMoney = amount.multiply(COMMISSION);

        clientService.subtractMoney(clientConfig.getId(), bankMoney);
        bankAccountService.updateCommission(bankMoney);
    }
}
