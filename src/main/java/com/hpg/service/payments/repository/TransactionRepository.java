package com.hpg.service.payments.repository;

import com.hpg.service.payments.models.dto.TransactionModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionModels, Long> {
}
