package ru.etozhealexis.test_task.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.etozhealexis.test_task.config.ClientConfig;
import ru.etozhealexis.test_task.model.Client;
import ru.etozhealexis.test_task.util.TestFieldUtil;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReturnServiceTest {

    @InjectMocks
    private ReturnService returnService;
    @Mock
    private BankAccountService bankAccountService;
    @Mock
    private ClientService clientService;
    @Mock
    private ClientConfig clientConfig;
    private final BigDecimal COMMISSION = BigDecimal.valueOf(0.1);

    @Test
    public void returnMoneyTest() {
        Client client = TestFieldUtil.generateTestClient();
        BigDecimal amount = BigDecimal.ONE;

        when(clientConfig.getId()).thenReturn(client.getId());

        returnService.returnMoney(amount);

        verify(clientService, times(1)).subtractMoney(client.getId(), amount.multiply(COMMISSION));
        verify(bankAccountService, times(1)).updateCommission(amount.multiply(COMMISSION));
    }

}
