package com.hpg.service.payments.controller;

import com.hpg.service.payments.event.events.PixPaymentEvents;
import com.hpg.service.payments.models.PixPaymentModels;
import com.hpg.service.payments.service.Validation.ValidateAccountsService;
import com.hpg.service.payments.service.Validation.ValidateBalanceBetweenAcccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payments/pix")
public class PixPaymentController {
    private final PixPaymentEvents producer;
    private ValidateAccountsService validateAccountsService;
    private ValidateBalanceBetweenAcccountService validateBalanceBetweenAcccountService;

    public PixPaymentController(PixPaymentEvents producer, ValidateBalanceBetweenAcccountService validateBalanceBetweenAcccountService, ValidateAccountsService validateAccountsService) {
        this.producer = producer;
        this.validateBalanceBetweenAcccountService = validateBalanceBetweenAcccountService;
        this.validateAccountsService = validateAccountsService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> SendPaymentPix(@Validated @RequestBody PixPaymentModels pixPaymentModels) {
        if (pixPaymentModels.getPixKey() == null || pixPaymentModels.getPixKey().isEmpty()) {
            return ResponseEntity.badRequest().body("Pix key is required");
        }

        boolean existsAccount = validateAccountsService.validateAccount(pixPaymentModels);
        if (!existsAccount) {
            return ResponseEntity.badRequest().body("Account not found for the provided Pix key");
        }

        boolean hasBalance = validateBalanceBetweenAcccountService.validateBalance(
                pixPaymentModels.getUserSendingId(), pixPaymentModels.getAmount());
        if (!hasBalance) {
            return ResponseEntity.badRequest().body("Insufficient balance for the transaction");
        }

        producer.sendPixPaymentEvent(pixPaymentModels);
        return ResponseEntity.ok("Pix payment processed successfully");
    }
}
