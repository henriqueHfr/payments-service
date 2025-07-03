package com.hpg.service.payments.event.listeners;

import com.hpg.service.payments.exception.CreateUserException;
import com.hpg.service.payments.models.AccountUserModel;
import com.hpg.service.payments.repository.AccountUserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CreateUserListerners {

    private final AccountUserRepository accountUserRepository;

    public CreateUserListerners(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }

     @KafkaListener(topics = "create-user-topic", groupId = "user-creation-group", containerFactory = "kafkaListenerContainerFactory")
     public void onUserCreated(AccountUserModel accountUserModel) {
         try {
             accountUserRepository.save(accountUserModel);
             System.out.println("User created: " + accountUserModel);
         } catch (DataIntegrityViolationException ex) {
             throw new CreateUserException("Erro ao persistir usuário: dados inválidos.", ex);
         } catch (Exception ex) {
             throw new CreateUserException("Erro inesperado ao criar usuário.", ex);
         }
     }
}
