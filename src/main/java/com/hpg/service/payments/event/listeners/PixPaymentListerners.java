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

    private final ValidateAccountsService validateAccountsService;
    private final ValidateBalanceBetweenAcccountService validateBalanceBetweenAcccountService;
    private final SendPixService sendPixService;

    public PixPaymentListerners(
            ValidateAccountsService validateAccountsService,
            ValidateBalanceBetweenAcccountService validateBalanceBetweenAcccountService,
            SendPixService sendPixService
    ) {
        this.validateAccountsService = validateAccountsService;
        this.validateBalanceBetweenAcccountService = validateBalanceBetweenAcccountService;
        this.sendPixService = sendPixService;
    }

    @KafkaListener(topics = "pix-payment-topic", groupId = "pagamento-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumer(PixPaymentModels pixPaymentModels) {
        sendPixService.sendPix(pixPaymentModels);
    }
}
