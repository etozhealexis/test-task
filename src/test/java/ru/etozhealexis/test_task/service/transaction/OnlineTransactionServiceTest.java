package ru.etozhealexis.test_task.service.transaction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.etozhealexis.test_task.config.ClientConfig;
import ru.etozhealexis.test_task.model.Client;
import ru.etozhealexis.test_task.service.BankAccountService;
import ru.etozhealexis.test_task.service.ClientService;
import ru.etozhealexis.test_task.util.TestFieldUtil;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OnlineTransactionServiceTest {

    @InjectMocks
    private OnlineTransactionService onlineTransactionService;
    @Mock
    private ClientService clientService;
    @Mock
    private BankAccountService bankAccountService;
    @Mock
    private ClientConfig clientConfig;

    private final BigDecimal BONUS = BigDecimal.valueOf(0.17);

    @Test
    public void makeTransactionTest() {
        Client client = TestFieldUtil.generateTestClient();
        BigDecimal amount = BigDecimal.valueOf(200);

        when(clientConfig.getId()).thenReturn(client.getId());

        onlineTransactionService.makeTransaction(amount);

        verify(clientService, times(1)).subtractMoney(client.getId(), amount);
        verify(bankAccountService, times(1)).updateOnlineBonus(amount.multiply(BONUS));
    }
}
