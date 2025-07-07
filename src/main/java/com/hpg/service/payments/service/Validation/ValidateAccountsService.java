package com.hpg.service.payments.service.Validation;

import com.hpg.service.payments.models.AccountUserModel;
import com.hpg.service.payments.models.PixPaymentModels;
import com.hpg.service.payments.repository.AccountUserRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidateAccountsService {

    private AccountUserRepository accountUserRepository;

    public ValidateAccountsService(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }

    public Boolean validateAccount(PixPaymentModels pixPaymentModels) {
        AccountUserModel userSending = accountUserRepository.findByUserId(pixPaymentModels.getUserSendingId())
                .orElseThrow(() -> new RuntimeException("Conta de envio não encontrada"));

        AccountUserModel userReceiving = accountUserRepository.findByUserPixKey(pixPaymentModels.getPixKey())
                .orElseThrow(() -> new RuntimeException("Conta de recebimento não encontrada"));

        if(!userSending.getUserId().equals(pixPaymentModels.getUserSendingId()) || !userReceiving.getUserPixKey().equals(pixPaymentModels.getPixKey())) {
            return false;
        }

        return true;
    }
}
