package ru.etozhealexis.test_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import ru.etozhealexis.test_task.dto.BankAccountEMoneyDTO;
import ru.etozhealexis.test_task.dto.ClientMoneyDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestTaskTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private final String API_MONEY_URL = "/api/money";
    private final String API_BANK_ACCOUNT_OF_EMONEY_URL = "/api/bankAccountOfEMoney";
    private final String API_PAYMENT_URL = "/api/payment";
    private final String ONLINE_PAYMENT = "/Online";
    private final String SHOP_PAYMENT = "/Shop";


    @Test
    public void online100RequestTest() {
        BigDecimal clientMoneyBefore = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal onlineBonusBefore = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getOnlineBonus();

        testRestTemplate.getForEntity(API_PAYMENT_URL + ONLINE_PAYMENT + "/100", null);

        BigDecimal clientMoneyAfter = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal onlineBonusAfter = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getOnlineBonus();

        Assertions.assertEquals(BigDecimal.valueOf(100.00).setScale(3, RoundingMode.CEILING),
                clientMoneyBefore.subtract(clientMoneyAfter).setScale(3, RoundingMode.CEILING));
        Assertions.assertEquals(BigDecimal.valueOf(17.00).setScale(3,
                RoundingMode.CEILING), onlineBonusAfter.subtract(onlineBonusBefore).setScale(3, RoundingMode.CEILING));
    }

    @Test
    public void shop120RequestTest() {
        BigDecimal clientMoneyBefore = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal shopBonusBefore = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getShopBonus();

        testRestTemplate.getForEntity(API_PAYMENT_URL + SHOP_PAYMENT + "/120", null);

        BigDecimal clientMoneyAfter = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal shopBonusAfter = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getShopBonus();

        Assertions.assertEquals(BigDecimal.valueOf(120.00).setScale(3, RoundingMode.CEILING),
                clientMoneyBefore.subtract(clientMoneyAfter).setScale(3, RoundingMode.CEILING));
        Assertions.assertEquals(BigDecimal.valueOf(12.00).setScale(3,
                RoundingMode.CEILING), shopBonusAfter.subtract(shopBonusBefore).setScale(3, RoundingMode.CEILING));
    }

    @Test
    public void online301RequestTest() {
        BigDecimal clientMoneyBefore = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal onlineBonusBefore = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getOnlineBonus();

        testRestTemplate.getForEntity(API_PAYMENT_URL + ONLINE_PAYMENT + "/301", null);

        BigDecimal clientMoneyAfter = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal onlineBonusAfter = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getOnlineBonus();

        Assertions.assertEquals(BigDecimal.valueOf(301.00).setScale(3, RoundingMode.CEILING),
                clientMoneyBefore.subtract(clientMoneyAfter).setScale(3, RoundingMode.CEILING));
        Assertions.assertEquals(BigDecimal.valueOf(51.17).setScale(3,
                RoundingMode.CEILING), onlineBonusAfter.subtract(onlineBonusBefore).setScale(3, RoundingMode.CEILING));
    }

    @Test
    public void online17RequestTest() {
        BigDecimal clientMoneyBefore = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal onlineBonusBefore = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getOnlineBonus();

        testRestTemplate.getForEntity(API_PAYMENT_URL + ONLINE_PAYMENT + "/17", null);

        BigDecimal clientMoneyAfter = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal onlineBonusAfter = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getOnlineBonus();

        Assertions.assertEquals(BigDecimal.valueOf(1.7).setScale(3, RoundingMode.CEILING),
                clientMoneyBefore.subtract(clientMoneyAfter).setScale(3, RoundingMode.CEILING));
        Assertions.assertEquals(BigDecimal.valueOf(0).setScale(3,
                RoundingMode.CEILING), onlineBonusAfter.subtract(onlineBonusBefore).setScale(3, RoundingMode.CEILING));
    }

    @Test
    public void shop1000RequestTest() {
        BigDecimal clientMoneyBefore = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal shopBonusBefore = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getShopBonus();

        testRestTemplate.getForEntity(API_PAYMENT_URL + SHOP_PAYMENT + "/1000", null);

        BigDecimal clientMoneyAfter = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal shopBonusAfter = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getShopBonus();

        Assertions.assertEquals(BigDecimal.valueOf(1000.00).setScale(3, RoundingMode.CEILING),
                clientMoneyBefore.subtract(clientMoneyAfter).setScale(3, RoundingMode.CEILING));
        Assertions.assertEquals(BigDecimal.valueOf(100.00).setScale(3,
                RoundingMode.CEILING), shopBonusAfter.subtract(shopBonusBefore).setScale(3, RoundingMode.CEILING));
    }

    @Test
    public void online21RequestTest() {
        BigDecimal clientMoneyBefore = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal onlineBonusBefore = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getOnlineBonus();

        testRestTemplate.getForEntity(API_PAYMENT_URL + ONLINE_PAYMENT + "/21", null);

        BigDecimal clientMoneyAfter = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal onlineBonusAfter = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getOnlineBonus();

        Assertions.assertEquals(BigDecimal.valueOf(21).setScale(3, RoundingMode.CEILING),
                clientMoneyBefore.subtract(clientMoneyAfter).setScale(3, RoundingMode.CEILING));
        Assertions.assertEquals(BigDecimal.valueOf(3.57).setScale(3,
                RoundingMode.CEILING), onlineBonusAfter.subtract(onlineBonusBefore).setScale(3, RoundingMode.CEILING));
    }

    @Test
    public void shop570RequestTest() {
        BigDecimal clientMoneyBefore = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal shopBonusBefore = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getShopBonus();

        testRestTemplate.getForEntity(API_PAYMENT_URL + SHOP_PAYMENT + "/570", null);

        BigDecimal clientMoneyAfter = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal shopBonusAfter = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getShopBonus();

        Assertions.assertEquals(BigDecimal.valueOf(570.00).setScale(3, RoundingMode.CEILING),
                clientMoneyBefore.subtract(clientMoneyAfter).setScale(3, RoundingMode.CEILING));
        Assertions.assertEquals(BigDecimal.valueOf(57.00).setScale(3,
                RoundingMode.CEILING), shopBonusAfter.subtract(shopBonusBefore).setScale(3, RoundingMode.CEILING));
    }

    @Test
    public void online700RequestTest() {
        BigDecimal clientMoneyBefore = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal onlineBonusBefore = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getOnlineBonus();

        testRestTemplate.getForEntity(API_PAYMENT_URL + ONLINE_PAYMENT + "/700", null);

        BigDecimal clientMoneyAfter = testRestTemplate.getForObject(API_MONEY_URL, ClientMoneyDTO.class).getMoney();
        BigDecimal onlineBonusAfter = testRestTemplate.getForObject(API_BANK_ACCOUNT_OF_EMONEY_URL, BankAccountEMoneyDTO.class).getOnlineBonus();

        Assertions.assertEquals(BigDecimal.valueOf(700).setScale(3, RoundingMode.CEILING),
                clientMoneyBefore.subtract(clientMoneyAfter).setScale(3, RoundingMode.CEILING));
        Assertions.assertEquals(BigDecimal.valueOf(119).setScale(3,
                RoundingMode.CEILING), onlineBonusAfter.subtract(onlineBonusBefore).setScale(3, RoundingMode.CEILING));
    }
}
