package ru.etozhealexis.test_task.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.etozhealexis.test_task.config.dbentity.BankAccountConfig;
import ru.etozhealexis.test_task.mapper.BankAccountMapper;
import ru.etozhealexis.test_task.model.BankAccount;
import ru.etozhealexis.test_task.repository.BankAccountRepository;
import ru.etozhealexis.test_task.util.TestFieldUtil;

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
    @Mock
    private BankAccountConfig bankAccountConfig;

    @Test
    public void getBankAccountEMoneyDTOTest() {
        BankAccount bankAccount = TestFieldUtil.generateTestBankAccount();

        when(bankAccountConfig.getId()).thenReturn(bankAccount.getId());

        bankAccountService.getBankAccountEMoneyDTO();

        verify(bankAccountRepository, times(1)).getBankAccount(bankAccount.getId());
        verify(bankAccountMapper, times(1)).mapToBankAccountEMoneyDTO(any());
    }

    @Test
    public void getBankAccountTest() {
        BankAccount bankAccount = TestFieldUtil.generateTestBankAccount();

        when(bankAccountConfig.getId()).thenReturn(bankAccount.getId());

        bankAccountService.getBankAccount(bankAccountConfig.getId());

        verify(bankAccountRepository, times(1)).getBankAccount(bankAccountConfig.getId());
    }

    @Test
    public void updateCommissionTest() {
        BankAccount bankAccount = TestFieldUtil.generateTestBankAccount();
        BigDecimal amount = BigDecimal.ONE;

        when(bankAccountConfig.getId()).thenReturn(bankAccount.getId());

        bankAccountService.updateCommission(amount);

        verify(bankAccountRepository, times(1)).updateCommission(amount, bankAccount.getId());
    }

    @Test
    public void updateOnlineBonusTest() {
        BankAccount bankAccount = TestFieldUtil.generateTestBankAccount();
        BigDecimal amount = BigDecimal.ONE;

        when(bankAccountConfig.getId()).thenReturn(bankAccount.getId());

        bankAccountService.updateOnlineBonus(amount);

        verify(bankAccountRepository, times(1)).updateOnlineBonus(amount, bankAccount.getId());
    }

    @Test
    public void updateShopBonusTest() {
        BankAccount bankAccount = TestFieldUtil.generateTestBankAccount();
        BigDecimal amount = BigDecimal.ONE;

        when(bankAccountConfig.getId()).thenReturn(bankAccount.getId());

        bankAccountService.updateShopBonus(amount);

        verify(bankAccountRepository, times(1)).updateShopBonus(amount, bankAccountConfig.getId());
    }
}
