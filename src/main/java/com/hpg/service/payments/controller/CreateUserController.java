package com.hpg.service.payments.controller;

import com.hpg.service.payments.event.events.CreateUserEvents;
import com.hpg.service.payments.models.AccountUserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/create/user")
public class CreateUserController {

    private final CreateUserEvents producer;

    public CreateUserController(CreateUserEvents producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@Validated @RequestBody AccountUserModel accountUserModel) {
        producer.sendCreateUserEvent(accountUserModel);
        return ResponseEntity.ok("User created successfully");
    }
}
