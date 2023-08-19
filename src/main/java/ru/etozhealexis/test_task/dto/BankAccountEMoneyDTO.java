package ru.etozhealexis.test_task.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO-класс, включающий в себя два поля:
 * shopBonus - бонусы магазина
 * onlineBonus - бонусы онлайн-покупок
 */

@Builder
@Data
public class BankAccountEMoneyDTO {
    private BigDecimal shopBonus;
    private BigDecimal onlineBonus;
}
