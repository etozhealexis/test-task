package ru.etozhealexis.test_task.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.test_task.dto.BankAccountEMoneyDTO;
import ru.etozhealexis.test_task.service.BankAccountService;

/**
 * rest-контроллер для получения бонусов
 * магазина и онлайн-покупок
 */

@RestController
@RequestMapping("/api")
public class EMoneyRestController {
    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/bankAccountOfEMoney")
    public BankAccountEMoneyDTO getBankAccountOfEMoney() {
        return bankAccountService.getBankAccountEMoneyDTO();
    }
}
