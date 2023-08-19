package ru.etozhealexis.test_task.util;

import ru.etozhealexis.test_task.dto.BankAccountEMoneyDTO;
import ru.etozhealexis.test_task.dto.ClientMoneyDTO;
import ru.etozhealexis.test_task.model.BankAccount;
import ru.etozhealexis.test_task.model.Client;

import java.math.BigDecimal;

public class TestFieldUtil {

    public static Client generateTestClient() {
        return Client.builder()
                .id(123L)
                .money(BigDecimal.valueOf(5000))
                .build();
    }

    public static ClientMoneyDTO generateClientMoneyDTO() {
        return ClientMoneyDTO.builder()
                .money(BigDecimal.valueOf(5000))
                .build();
    }

    public static BankAccount generateTestBankAccount() {
        return BankAccount.builder()
                .id(123L)
                .shopBonus(BigDecimal.ZERO)
                .onlineBonus(BigDecimal.ZERO)
                .commission(BigDecimal.ZERO)
                .build();
    }

    public static BankAccountEMoneyDTO generateTestBankAccountEMoneyDTO() {
        return BankAccountEMoneyDTO.builder()
                .shopBonus(BigDecimal.ZERO)
                .onlineBonus(BigDecimal.ZERO)
                .build();
    }
}
