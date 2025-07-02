package com.hpg.service.payments.repository;

import com.hpg.service.payments.models.AccountUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountUserRepository extends JpaRepository<AccountUserModel, Long> {

    // Custom query to find user by email
    AccountUserModel findByUserEmail(String userEmail);

    // Custom query to find user by phone
    AccountUserModel findByUserPhone(String userPhone);

    // Custom query to find user by Pix key
    AccountUserModel findByUserPixKey(String userPixKey);

    // Custom query to find user by Pix key type
    AccountUserModel findByUserPixKeyType(String userPixKeyType);

    AccountUserModel findByUserValueBalance(Double userValueBalance);
}
