package ru.etozhealexis.test_task.mapper;

import org.springframework.stereotype.Component;
import ru.etozhealexis.test_task.dto.BankAccountEMoneyDTO;
import ru.etozhealexis.test_task.model.BankAccount;

/**
 * Класс-маппер для обертывания бонусов
 * онлайн-покупок и магазина в DTO
 */

@Component
public class BankAccountMapper {
    public BankAccountEMoneyDTO mapToBankAccountEMoneyDTO(BankAccount bankAccount) {
        return BankAccountEMoneyDTO.builder()
                .onlineBonus(bankAccount.getOnlineBonus())
                .shopBonus(bankAccount.getShopBonus())
                .build();
    }
}
