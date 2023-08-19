package ru.etozhealexis.test_task.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Класс-конфигурация для получения id клиента из бд
 */

@ConfigurationProperties("client")
@Configuration
@Getter
@Setter
public class ClientConfig {
    private Long id;
}
