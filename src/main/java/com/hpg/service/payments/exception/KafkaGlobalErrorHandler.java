package com.hpg.service.payments.exception;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.stereotype.Component;

@Component
public class KafkaGlobalErrorHandler implements CommonErrorHandler {

    public void handle(Exception thrownException, ConsumerRecord<?, ?> data) {
        System.err.println("Erro ao processar mensagem Kafka:");
        System.err.println("Mensagem: " + data);
        System.err.println("Exceção: " + thrownException.getMessage());
    }
}
