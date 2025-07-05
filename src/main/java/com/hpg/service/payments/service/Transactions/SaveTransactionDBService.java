package com.hpg.service.payments.service.Transactions;

import com.hpg.service.payments.models.dto.TransactionModels;
import com.hpg.service.payments.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveTransactionDBService {

    private TransactionRepository transactionRepository;

    public SaveTransactionDBService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void saveTransaction(TransactionModels transactionModels) {
        try {
            transactionRepository.save(transactionModels);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar transação: " + e.getMessage());
        }
    }
}
