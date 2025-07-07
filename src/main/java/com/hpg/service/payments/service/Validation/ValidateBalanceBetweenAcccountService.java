package com.hpg.service.payments.service.Validation;

import com.hpg.service.payments.repository.AccountUserRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidateBalanceBetweenAcccountService {

    private AccountUserRepository accountUserRepository;

    public ValidateBalanceBetweenAcccountService(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }

    public Boolean validateBalance(Long userSendingId, Double amount) {

        Double balanceSending = accountUserRepository.findById(userSendingId)
                .orElseThrow(() -> new RuntimeException("Conta de envio não encontrada"))
                .getUserValueBalance();

        return balanceSending < amount ? false : true;
    }
}
