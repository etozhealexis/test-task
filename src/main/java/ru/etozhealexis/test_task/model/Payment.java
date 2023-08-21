package ru.etozhealexis.test_task.model;

import lombok.*;
import ru.etozhealexis.test_task.config.statemachine.state.PaymentState;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * модель платежа клиента
 */

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentState paymentState;

    private BigDecimal amount;
}
