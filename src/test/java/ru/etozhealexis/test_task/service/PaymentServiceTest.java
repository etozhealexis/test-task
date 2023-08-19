package ru.etozhealexis.test_task.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.etozhealexis.test_task.service.transaction.ShopTransactionService;
import ru.etozhealexis.test_task.service.transaction.TransactionService;

import java.math.BigDecimal;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;
    @Mock
    private ReturnService returnService;
    @Mock
    private ShopTransactionService transactionService;
    @Mock
    private Map<String, TransactionService> transactionServiceMap;

    @Test
    public void payTestWhenAmountIsBigger() {
        BigDecimal amount = BigDecimal.valueOf(200);

        when(transactionServiceMap.get("Shop")).thenReturn(transactionService);

        paymentService.pay("Shop", amount);

        verify(transactionService, times(1)).makeTransaction(amount);
    }

    @Test
    public void payTestWhenReturnSumIsBigger() {
        BigDecimal amount = BigDecimal.ONE;

        paymentService.pay("Shop", amount);

        verify(returnService, times(1)).returnMoney(amount);
    }
}
