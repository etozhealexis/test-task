package ru.etozhealexis.test_task.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Модель клиента
 */

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", sequenceName = "client_seq", allocationSize = 1)
    private Long id;

    /**
     * средства клиента
     */
    private BigDecimal money;

    /**
     * бонусы клиента
     */
    private BigDecimal bonus;
}
