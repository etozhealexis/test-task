package ru.etozhealexis.test_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.etozhealexis.test_task.model.Client;

import java.math.BigDecimal;

/**
 * Класс-репозиторий, отвечающий за общение
 * с таблицей client
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    /**
     * метод, возвращающий текущее количество средств клиента
     * @param clientId - id клиента
     * @return средства клиента
     */
    @Query("SELECT c.money FROM Client c WHERE c.id = :clientId")
    BigDecimal getClientMoney(@Param("clientId") Long clientId);

    /**
     * метод, списывающий средства со счета клиента
     * @param clientId - id клиента
     * @param amount - количество средств, которое необходимо списать
     */
    @Modifying
    @Query("UPDATE Client c SET c.money = c.money - :amount WHERE c.id = :clientId")
    void subtractMoney(@Param("clientId") Long clientId, @Param("amount") BigDecimal amount);

    /**
     * метод, добавляющий бонусы к счету клиента
     * @param clientId - id клиента
     * @param amount - количество бонусов, необходимое зачислить на счет
     */
    @Modifying
    @Query("UPDATE Client c SET c.bonus = c.bonus + :amount WHERE c.id = :clientId")
    void addBonus(@Param("clientId") Long clientId, @Param("amount") BigDecimal amount);
}
