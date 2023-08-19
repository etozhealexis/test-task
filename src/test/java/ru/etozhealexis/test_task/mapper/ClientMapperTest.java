package ru.etozhealexis.test_task.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.etozhealexis.test_task.dto.ClientMoneyDTO;
import ru.etozhealexis.test_task.model.Client;
import ru.etozhealexis.test_task.util.TestFieldUtil;


@ExtendWith(MockitoExtension.class)
public class ClientMapperTest {

    @InjectMocks
    private ClientMapper clientMapper;

    @Test
    public void mapToClientMoneyDTOTest() {
        Client client = TestFieldUtil.generateTestClient();
        ClientMoneyDTO clientMoneyDTO = clientMapper.mapToClientMoneyDTO(client.getMoney());

        Assertions.assertEquals(client.getMoney(), clientMoneyDTO.getMoney());
    }
}
