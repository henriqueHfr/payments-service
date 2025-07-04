package com.hpg.service.payments.repository;

import com.hpg.service.payments.models.AccountUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface AccountUserRepository extends JpaRepository<AccountUserModel, Long> {

    AccountUserModel findByUserEmail(String userEmail);

    AccountUserModel findByUserPhone(String userPhone);

    Optional<AccountUserModel> findByUserPixKey(String userPixKey);

    AccountUserModel findByUserPixKeyType(String userPixKeyType);

    AccountUserModel findByUserValueBalance(Double uerValueBalance);
}
