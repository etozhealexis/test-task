package ru.etozhealexis.test_task.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.test_task.config.dbentity.ClientConfig;
import ru.etozhealexis.test_task.dto.ClientMoneyDTO;
import ru.etozhealexis.test_task.service.ClientService;

/**
 * rest-контроллер для получения текущих
 * средств клиента
 */

@RestController
@RequestMapping("/api")
public class MoneyRestController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientConfig clientConfig;

    @GetMapping("/money")
    public ClientMoneyDTO getClientMoney() {
        return clientService.getClientMoneyDTOById(clientConfig.getId());
    }
}
