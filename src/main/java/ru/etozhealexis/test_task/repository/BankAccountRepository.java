package ru.etozhealexis.test_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.etozhealexis.test_task.model.BankAccount;

import java.math.BigDecimal;

/**
 * Класс-репозиторий, отвечающий за общение
 * с таблицей bank_account
 * (поскольку я посчитал, что у банка всего один аккаунт,
 * завел одну запись в бд и обращался к ней по id = 1)
 */

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    /**
     * метод возвращения всего аккаунта банка
     * @return аккаунт банка
     */
    @Query("SELECT ba FROM BankAccount ba WHERE ba.id = 1")
    BankAccount getBankAccount();

    /**
     * метод увеличения средств, пришедших за коммиссию
     * @param amount - коммиссия
     */
    @Modifying
    @Query("UPDATE BankAccount ba SET ba.commission = ba.commission + :amount WHERE ba.id = 1")
    void updateCommission(@Param("amount") BigDecimal amount);

    /**
     * метод увеличения средств, пришедших за покупку в онлайн-покупках
     * @param amount - процент от покупки
     */
    @Modifying
    @Query("UPDATE BankAccount ba SET ba.onlineBonus = ba.onlineBonus + :amount WHERE ba.id = 1")
    void updateOnlineBonus(@Param("amount") BigDecimal amount);

    /**
     * метод увеличения средств, пришедших за покупку в магазине
     * @param amount - процент от покупки
     */
    @Modifying
    @Query("UPDATE BankAccount ba SET ba.shopBonus = ba.shopBonus + :amount WHERE ba.id = 1")
    void updateShopBonus(@Param("amount") BigDecimal amount);
}
