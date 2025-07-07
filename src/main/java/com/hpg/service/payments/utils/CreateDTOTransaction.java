package com.hpg.service.payments.utils;

import com.hpg.service.payments.models.AccountUserModel;
import com.hpg.service.payments.models.PixPaymentModels;
import com.hpg.service.payments.models.dto.TransactionModels;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class CreateDTOTransaction {

    public TransactionModels createTransactionDTO(AccountUserModel userSending, AccountUserModel userReceive, PixPaymentModels pixPaymentModels, String transactionId, Date transactionDate) {

        TransactionModels transaction = new TransactionModels();
        transaction.setUserSendingId(userSending.getUserId());
        transaction.setUserReceiveId(userReceive.getUserId());
        transaction.setUserPixKey(pixPaymentModels.getPixKey());
        transaction.setTransactionId(transactionId);
        transaction.setUserPixKeyType(pixPaymentModels.getPixKeyType());
        transaction.setTransactionValue(pixPaymentModels.getAmount());
        transaction.setTransactionDate(transactionDate);
        transaction.setUserSendingBalanceInitial(userSending.getUserValueBalance());
        transaction.setUserReceiveBalanceInitial(userReceive.getUserValueBalance());

        return transaction;
    }
}
