package ru.etozhealexis.test_task.service.transaction;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * интерфейс, представляющий собой поведение
 * совершения транзакции
 */
@Service
public interface TransactionService {

    void makeTransaction(BigDecimal amount);
}
