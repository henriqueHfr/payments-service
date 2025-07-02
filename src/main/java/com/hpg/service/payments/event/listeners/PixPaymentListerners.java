package com.hpg.service.payments.event.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PixPaymentListerners {

    @KafkaListener(topics = "pix-payment-topic", groupId = "pagamento-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumer(String pixPaymentModels) {
        System.out.println("Recebido pagamento confirmado para usuário: " + pixPaymentModels);
    }
}

