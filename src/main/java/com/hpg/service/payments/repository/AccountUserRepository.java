package com.hpg.service.payments.repository;

import com.hpg.service.payments.models.AccountUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountUserRepository extends JpaRepository<AccountUserModel, Long> {

    AccountUserModel findByUserEmail(String userEmail);

    AccountUserModel findByUserPhone(String userPhone);

    AccountUserModel findByUserPixKey(String userPixKey);

    AccountUserModel findByUserPixKeyType(String userPixKeyType);

    AccountUserModel findByUserValueBalance(Double userValueBalance);
}
