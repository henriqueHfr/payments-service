package com.hpg.service.payments.controller;

import com.hpg.service.payments.event.events.PixPaymentEvents;
import com.hpg.service.payments.models.PixPaymentModels;
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

    public PixPaymentController(PixPaymentEvents producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public ResponseEntity<String> SendPaymentPix(@Validated @RequestBody PixPaymentModels pixPaymentModels) {
        if (pixPaymentModels.getPixKey() == null || pixPaymentModels.getPixKey().isEmpty()) {
            return ResponseEntity.badRequest().body("Pix key is required");
        }
        producer.sendPixPaymentEvent(pixPaymentModels);
        return ResponseEntity.ok("Pix payment processed successfully");
    }
}
