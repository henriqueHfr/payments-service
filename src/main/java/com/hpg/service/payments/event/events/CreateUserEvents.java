package com.hpg.service.payments.event.events;

import com.hpg.service.payments.models.AccountUserModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CreateUserEvents {

    private final KafkaTemplate <String, AccountUserModel> kafkaTemplate;

    public CreateUserEvents(KafkaTemplate<String, AccountUserModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCreateUserEvent(AccountUserModel accountUserModel) {
        try {
            kafkaTemplate.send("create-user-topic", accountUserModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
