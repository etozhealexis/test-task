package ru.etozhealexis.test_task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.etozhealexis.test_task.dto.ClientMoneyDTO;
import ru.etozhealexis.test_task.mapper.ClientMapper;
import ru.etozhealexis.test_task.repository.ClientRepository;

import java.math.BigDecimal;

/**
 * сервисный слой для клиента
 */

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    /**
     * метод, отвечающий за списывание средств со счета клиента
     * @param clientId - id клиента
     * @param amount - средства, затраченные на совершение покупки
     */
    @Transactional
    public void subtractMoney(Long clientId, BigDecimal amount) {
        clientRepository.subtractMoney(clientId, amount);
    }

    @Transactional
    public void addBonus(Long clientId, BigDecimal amount) {
        clientRepository.addBonus(clientId, amount);
    }

    /**
     * метод, отвечающий за получение средств клиента
     * @param clientId - id клиента
     * @return средства клиента в виде DTO
     */
    public ClientMoneyDTO getClientMoneyDTOById(Long clientId) {
        return clientMapper.mapToClientMoneyDTO(getClientMoneyById(clientId));
    }

    /**
     * метод, возвращающий средства клиента
     * @param clientId - id клиента
     * @return средства клиента
     */
    public BigDecimal getClientMoneyById(Long clientId) {
        return clientRepository.getClientMoney(clientId);
    }
}
