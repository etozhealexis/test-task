package ru.etozhealexis.test_task.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.etozhealexis.test_task.dto.BankAccountEMoneyDTO;
import ru.etozhealexis.test_task.model.BankAccount;
import ru.etozhealexis.test_task.util.TestFieldUtil;


@ExtendWith(MockitoExtension.class)
public class BankAccountMapperTest {

    @InjectMocks
    private BankAccountMapper bankAccountMapper;

    @Test
    public void mapToBankAccountEMoneyDTOTest() {
        BankAccount bankAccount = TestFieldUtil.generateTestBankAccount();
        BankAccountEMoneyDTO bankAccountEMoneyDTO = bankAccountMapper.mapToBankAccountEMoneyDTO(bankAccount);

        Assertions.assertEquals(bankAccount.getOnlineBonus(), bankAccountEMoneyDTO.getOnlineBonus());
        Assertions.assertEquals(bankAccount.getShopBonus(), bankAccountEMoneyDTO.getShopBonus());
    }
}
