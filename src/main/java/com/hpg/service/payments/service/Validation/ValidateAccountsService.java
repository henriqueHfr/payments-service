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

        System.out.println("Validando contas");
        System.out.println("Conta de envio: " + userSending.getUserId() + ", Conta de recebimento: " + userReceiving.getUserPixKey());
        System.out.println("UserSendinId: " + pixPaymentModels.getUserSendingId() + ", PixKey: " + pixPaymentModels.getPixKey());

        if(!userSending.getUserId().equals(pixPaymentModels.getUserSendingId()) || !userReceiving.getUserPixKey().equals(pixPaymentModels.getPixKey())) {
            System.out.println("Entrei no if de validação de contas");
            return false;
        }

        System.out.print("Contas validadas com sucesso: " + userSending.getUserId() + " -> " + userReceiving.getUserPixKey());

        return true;
    }
}
