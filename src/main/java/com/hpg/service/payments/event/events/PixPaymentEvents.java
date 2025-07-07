package com.hpg.service.payments.event.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hpg.service.payments.models.AccountUserModel;
import com.hpg.service.payments.models.PixPaymentModels;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PixPaymentEvents {

    private final KafkaTemplate<String, PixPaymentModels> kafkaTemplate;

    public PixPaymentEvents(KafkaTemplate<String, PixPaymentModels> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPixPaymentEvent(PixPaymentModels pixPaymentModels) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(pixPaymentModels);
            kafkaTemplate.send("pix-payment-topic", pixPaymentModels);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
