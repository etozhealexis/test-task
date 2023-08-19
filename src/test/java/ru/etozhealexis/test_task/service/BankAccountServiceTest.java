package ru.etozhealexis.test_task.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.etozhealexis.test_task.mapper.BankAccountMapper;
import ru.etozhealexis.test_task.repository.BankAccountRepository;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BankAccountServiceTest {

    @InjectMocks
    private BankAccountService bankAccountService;
    @Mock
    private BankAccountRepository bankAccountRepository;
    @Mock
    private BankAccountMapper bankAccountMapper;

    @Test
    public void getBankAccountEMoneyDTOTest() {
        bankAccountService.getBankAccountEMoneyDTO();

        verify(bankAccountRepository, times(1)).getBankAccount();
        verify(bankAccountMapper, times(1)).mapToBankAccountEMoneyDTO(any());
    }

    @Test
    public void getBankAccountTest() {
        bankAccountService.getBankAccount();

        verify(bankAccountRepository, times(1)).getBankAccount();
    }

    @Test
    public void updateCommissionTest() {
        BigDecimal amount = BigDecimal.ONE;

        bankAccountService.updateCommission(amount);

        verify(bankAccountRepository, times(1)).updateCommission(amount);
    }

    @Test
    public void updateOnlineBonusTest() {
        BigDecimal amount = BigDecimal.ONE;

        bankAccountService.updateOnlineBonus(amount);

        verify(bankAccountRepository, times(1)).updateOnlineBonus(amount);
    }

    @Test
    public void updateShopBonusTest() {
        BigDecimal amount = BigDecimal.ONE;

        bankAccountService.updateShopBonus(amount);

        verify(bankAccountRepository, times(1)).updateShopBonus(amount);
    }
}
