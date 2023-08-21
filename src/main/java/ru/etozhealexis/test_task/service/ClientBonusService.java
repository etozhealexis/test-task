package ru.etozhealexis.test_task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.etozhealexis.test_task.config.dbentity.ClientConfig;

import java.math.BigDecimal;

/**
 * сервис, отвечающий за начисление бонусов
 * на счет клиента
 */

@Service
public class ClientBonusService {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientConfig clientConfig;
    private final BigDecimal BONUS = BigDecimal.valueOf(0.3);

    public void addBonus(BigDecimal amount) {
        clientService.addBonus(clientConfig.getId(), amount.multiply(BONUS));
    }
}
