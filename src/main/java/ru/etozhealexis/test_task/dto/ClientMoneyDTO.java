package ru.etozhealexis.test_task.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO-класс, включающий в себя одно поле:
 * money - средства клиента
 */

@Builder
@Data
public class ClientMoneyDTO {
    private BigDecimal money;
}
