package ru.etozhealexis.test_task.mapper;

import org.springframework.stereotype.Component;
import ru.etozhealexis.test_task.dto.ClientMoneyDTO;

import java.math.BigDecimal;

/**
 * Класс-маппер для обертывания средств
 * клиента в DTO
 */

@Component
public class ClientMapper {

    public ClientMoneyDTO mapToClientMoneyDTO(BigDecimal money) {
        return ClientMoneyDTO.builder()
                .money(money)
                .build();
    }
}
