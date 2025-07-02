package com.hpg.service.payments.event.listeners;

import com.hpg.service.payments.models.AccountUserModel;
import com.hpg.service.payments.repository.AccountUserRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CreateUserListerners {

    private AccountUserRepository accountUserRepository;

    public CreateUserListerners(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }

     @KafkaListener(topics = "create-user-topic", groupId = "user-creation-group", containerFactory = "kafkaListenerContainerFactory")
     public void onUserCreated(AccountUserModel accountUserModel) {
        AccountUserModel user =  new AccountUserModel();
        user =  accountUserModel;
        accountUserRepository.save(user);
        System.out.println("User created: " + accountUserModel);
     }
}
