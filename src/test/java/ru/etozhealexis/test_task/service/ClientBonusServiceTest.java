package ru.etozhealexis.test_task.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.etozhealexis.test_task.config.dbentity.ClientConfig;
import ru.etozhealexis.test_task.model.Client;
import ru.etozhealexis.test_task.util.TestFieldUtil;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientBonusServiceTest {

    @InjectMocks
    private ClientBonusService clientBonusService;
    @Mock
    private ClientService clientService;
    @Mock
    private ClientConfig clientConfig;
    private final BigDecimal BONUS = BigDecimal.valueOf(0.3);

    @Test
    public void addBonus() {
        Client client = TestFieldUtil.generateTestClient();
        BigDecimal amount = BigDecimal.ONE;

        when(clientConfig.getId()).thenReturn(client.getId());

        clientBonusService.addBonus(amount);

        verify(clientService, times(1)).addBonus(client.getId(), amount.multiply(BONUS));
    }
}
