package ru.etozhealexis.test_task.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.etozhealexis.test_task.mapper.ClientMapper;
import ru.etozhealexis.test_task.model.Client;
import ru.etozhealexis.test_task.repository.ClientRepository;
import ru.etozhealexis.test_task.util.TestFieldUtil;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;
    @Mock
    private ClientMapper clientMapper;
    @Mock
    private ClientRepository clientRepository;

    @Test
    public void subtractMoneyTest() {
        Client client = TestFieldUtil.generateTestClient();
        BigDecimal amount = BigDecimal.ONE;

        clientService.subtractMoney(client.getId(), amount);

        verify(clientRepository, times(1)).subtractMoney(any(), any());
    }

    @Test
    public void addBonusTest() {
        Client client = TestFieldUtil.generateTestClient();
        BigDecimal amount = BigDecimal.ONE;

        clientService.addBonus(client.getId(), amount);

        verify(clientRepository, times(1)).addBonus(any(), any());
    }

    @Test
    public void getClientMoneyByIdTest() {
        Client client = TestFieldUtil.generateTestClient();

        when(clientRepository.getClientMoney(client.getId())).thenReturn(client.getMoney());

        clientService.getClientMoneyById(client.getId());

        verify(clientRepository, times(1)).getClientMoney(any());
    }

    @Test
    public void getClientMoneyDTOByIdTest() {
        Client client = TestFieldUtil.generateTestClient();

        when(clientRepository.getClientMoney(client.getId())).thenReturn(client.getMoney());

        clientService.getClientMoneyDTOById(client.getId());

        verify(clientRepository, times(1)).getClientMoney(any());
        verify(clientMapper, times(1)).mapToClientMoneyDTO(any());
    }
}
