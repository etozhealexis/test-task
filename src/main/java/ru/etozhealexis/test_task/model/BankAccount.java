package ru.etozhealexis.test_task.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Модель аккаунта банка
 */

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_seq")
    @SequenceGenerator(name = "bank_seq", sequenceName = "bank_seq", allocationSize = 1)
    private Long id;

    /**
     * возвращаемая банку комиссия за возвраты
     */
    private BigDecimal commission;

    /**
     * бонусы магазина
     */
    private BigDecimal shopBonus;

    /**
     * бонусы онлайн-покупок
     */
    private BigDecimal onlineBonus;
}
