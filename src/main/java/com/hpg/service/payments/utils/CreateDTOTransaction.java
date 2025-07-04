package com.hpg.service.payments.utils;

import com.hpg.service.payments.models.AccountUserModel;
import com.hpg.service.payments.models.PixPaymentModels;
import com.hpg.service.payments.models.dto.TransactionModels;

import java.util.Date;
import java.util.UUID;

public class CreateDTOTransaction {

    public TransactionModels createTransactionDTO(AccountUserModel userSending, AccountUserModel userReceive, PixPaymentModels pixPaymentModels) {

        String TransactionId = UUID.randomUUID().toString();
        Date transactionDate = new Date();

        TransactionModels transaction = new TransactionModels();
        transaction.setUserSendingId(userSending.getUserId());
        transaction.setUserSendingId(userReceive.getUserId());
        transaction.setUserPixKey(pixPaymentModels.getPixKey());
        transaction.setTransactionId(TransactionId);
        transaction.setUserPixKeyType(pixPaymentModels.getPixKeyType());
        transaction.setTransactionValue(pixPaymentModels.getAmount());
        transaction.setTransactionDate(transactionDate);
        transaction.setUserSendingBalanceInitial(userSending.getUserValueBalance());
        transaction.setUserReceiveBalanceInitial(userReceive.getUserValueBalance());

        return transaction;
    }
}
