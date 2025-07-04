package com.hpg.service.payments.event.listeners;

import com.hpg.service.payments.models.PixPaymentModels;
import com.hpg.service.payments.service.Transactions.SendPixService;
import com.hpg.service.payments.service.Validation.ValidateAccountsService;
import com.hpg.service.payments.service.Validation.ValidateBalanceBetweenAcccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PixPaymentListerners {

    private ValidateAccountsService validateAccountsService;

    private ValidateBalanceBetweenAcccountService ValidateBalanceBetweenAcccountService;

    private SendPixService sendPixService;

    @KafkaListener(topics = "pix-payment-topic", groupId = "pagamento-group", containerFactory = "kafkaListenerContainerFactory")
    public ResponseEntity<String> consumer(PixPaymentModels pixPaymentModels) {
        System.out.println("Recebido pagamento confirmado para usuário: " + pixPaymentModels);
        Boolean existsAccount = validateAccountsService.validateAccount(pixPaymentModels);

        if (!existsAccount) {
            return ResponseEntity.badRequest().body("Contas de recebimento ou de envio inválida ou não encontrada.");
        }

        Boolean validateBalance = ValidateBalanceBetweenAcccountService.validateBalance(pixPaymentModels.getUserSendingId(), pixPaymentModels.getAmount());

        if (!validateBalance) {
            return ResponseEntity.badRequest().body("Saldo insuficiente na conta de envio.");
        }

        sendPixService.sendPix(pixPaymentModels);

        return ResponseEntity.ok("Pagamento PIX processado com sucesso.");
    }
}

