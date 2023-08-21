package ru.etozhealexis.test_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.etozhealexis.test_task.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
