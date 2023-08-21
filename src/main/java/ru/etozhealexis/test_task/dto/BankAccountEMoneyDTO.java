package ru.etozhealexis.test_task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO-класс, включающий в себя два поля:
 * shopBonus - бонусы магазина
 * onlineBonus - бонусы онлайн-покупок
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountEMoneyDTO {
    private BigDecimal shopBonus;
    private BigDecimal onlineBonus;
}
