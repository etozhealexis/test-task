package ru.etozhealexis.test_task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO-класс, включающий в себя одно поле:
 * money - средства клиента
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientMoneyDTO {
    private BigDecimal money;
}
