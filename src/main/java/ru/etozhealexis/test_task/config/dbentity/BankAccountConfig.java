package ru.etozhealexis.test_task.config.dbentity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Класс-конфигурация для получения id аккаунта банка из бд
 */

@ConfigurationProperties("bank")
@Configuration
@Getter
@Setter
public class BankAccountConfig {
    private Long id;
}
