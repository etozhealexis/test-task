package ru.etozhealexis.test_task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.etozhealexis.test_task.dto.BankAccountEMoneyDTO;
import ru.etozhealexis.test_task.mapper.BankAccountMapper;
import ru.etozhealexis.test_task.model.BankAccount;
import ru.etozhealexis.test_task.repository.BankAccountRepository;

import java.math.BigDecimal;

/**
 * сервисный слой для аккаунта-банка
 */

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BankAccountMapper bankAccountMapper;

    /**
     * метод, отвечающий за получение бонусов по онлайн-покупкам и магазину
     * @return бонусы по онлайн-покупкам и магазину в виде DTO
     */
    public BankAccountEMoneyDTO getBankAccountEMoneyDTO() {
        return bankAccountMapper.mapToBankAccountEMoneyDTO(getBankAccount());
    }

    /**
     * метод, отвечающий за получение всего аккаунта банка
     * @return аккаунт банка
     */
    public BankAccount getBankAccount() {
        return bankAccountRepository.getBankAccount();
    }

    /**
     * метод, отвечабщий за начисление коммиссии аккаунту банка
     * @param amount - коммиссия
     */
    @Transactional
    public void updateCommission(BigDecimal amount) {
        bankAccountRepository.updateCommission(amount);
    }

    /**
     * метод, отвечабщий за начисление бонусов онлайн-покупкам
     * @param amount - бонус от онлайн-покупки
     */
    @Transactional
    public void updateOnlineBonus(BigDecimal amount) {
        bankAccountRepository.updateOnlineBonus(amount);
    }

    /**
     * метод, отвечабщий за начисление бонусов онлайн-покупкам
     * @param amount - бонус от магазина
     */
    @Transactional
    public void updateShopBonus(BigDecimal amount) {
        bankAccountRepository.updateShopBonus(amount);
    }
}
