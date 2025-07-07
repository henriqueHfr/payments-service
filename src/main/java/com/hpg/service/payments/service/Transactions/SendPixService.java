package com.hpg.service.payments.service.Transactions;

import com.hpg.service.payments.models.AccountUserModel;
import com.hpg.service.payments.models.PixPaymentModels;
import com.hpg.service.payments.models.dto.TransactionModels;
import com.hpg.service.payments.repository.AccountUserRepository;
import com.hpg.service.payments.utils.CreateDTOTransaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

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

        String TransactionId = UUID.randomUUID().toString();
        Date data = new Date();

        TransactionModels transaction = createDTOTransaction.createTransactionDTO(userSending, userReceive, pixPaymentModels, TransactionId, data);

        try {
            saveTransactionDBService.saveTransaction(transaction);

            userSending.setUserValueBalance(userSending.getUserValueBalance() - amount);
            userSending.setUserLastTransactionAmount(pixPaymentModels.getAmount());
            userSending.setUserLastTransactionDate(data);
            userSending.setUserLastTransactionId(TransactionId);

            userReceive.setUserValueBalance(userReceive.getUserValueBalance()+ amount);;
            userReceive.setUserLastTransactionAmount(pixPaymentModels.getAmount());
            userReceive.setUserLastTransactionDate(data);
            userReceive.setUserLastTransactionId(TransactionId);

            accountUserRepository.save(userSending);
            accountUserRepository.save(userReceive);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar transação PIX. Mudanças revertidas.", e);
        }
    }
}
