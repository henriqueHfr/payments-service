package com.hpg.service.payments.service.Transactions;

import com.hpg.service.payments.models.AccountUserModel;
import com.hpg.service.payments.models.PixPaymentModels;
import com.hpg.service.payments.models.dto.TransactionModels;
import com.hpg.service.payments.repository.AccountUserRepository;
import com.hpg.service.payments.repository.TransactionRepository;
import com.hpg.service.payments.utils.CreateDTOTransaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SendPixService {

    private final AccountUserRepository accountUserRepository;
    private final CreateDTOTransaction createDTOTransaction;
    private final SaveTransactionDBService saveTransactionDBService;

    public SendPixService(AccountUserRepository accountUserRepository,
                          CreateDTOTransaction createDTOTransaction,
                          SaveTransactionDBService saveTransactionDBService) {
        this.accountUserRepository = accountUserRepository;
        this.createDTOTransaction = createDTOTransaction;
        this.saveTransactionDBService = saveTransactionDBService;
    }

    @Transactional(rollbackFor = Exception.class)
    public void sendPix(PixPaymentModels pixPaymentModels) {
        AccountUserModel userSending = accountUserRepository.findById(pixPaymentModels.getUserSendingId())
                .orElseThrow(() -> new RuntimeException("Conta de envio não encontrada"));

        AccountUserModel userReceive = accountUserRepository.findByUserPixKey(pixPaymentModels.getPixKey())
                .orElseThrow(() -> new RuntimeException("Conta de recebimento não encontrada"));

        double amount = pixPaymentModels.getAmount();

        double originalSenderBalance = userSending.getUserValueBalance();
        double originalReceiverBalance = userReceive.getUserValueBalance();

        TransactionModels transaction = createDTOTransaction.createTransactionDTO(userSending, userReceive, pixPaymentModels);

        try {
            saveTransactionDBService.saveTransaction(transaction);

            userSending.setUserValueBalance(originalSenderBalance - amount);
            userReceive.setUserValueBalance(originalReceiverBalance + amount);

            accountUserRepository.save(userSending);
            accountUserRepository.save(userReceive);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar transação PIX. Mudanças revertidas.", e);
        }
    }
}
