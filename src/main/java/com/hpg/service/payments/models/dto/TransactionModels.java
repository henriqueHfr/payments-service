package com.hpg.service.payments.models.dto;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "transaction")
public class TransactionModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String transactionId;

    @Column(nullable = false)
    private Long userSendingId;

    @Column(nullable = false)
    private Long userReceiveId;

    @Column(nullable = false)
    private String userPixKey;

    @Column(nullable = false)
    private String userPixKeyType;

    @Column(nullable = false)
    private Double transactionValue;

    @Column(nullable = false)
    private Date transactionDate;

    @Column(nullable = false)
    private Double userSendingBalanceInitial;

    @Column(nullable = false)
    private Double userReceiveBalanceInitial;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setUserSendingId(Long userSendingId) {
        this.userSendingId = userSendingId;
    }

    public void setUserPixKey(String userPixKey) {
        this.userPixKey = userPixKey;
    }

    public void setUserPixKeyType(String userPixKeyType) {
        this.userPixKeyType = userPixKeyType;
    }

    public void setUserReceiveId(Long userReceiveId) {
        this.userReceiveId = userReceiveId;
    }

    public void setTransactionValue(Double transactionValue) {
        this.transactionValue = transactionValue;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setUserSendingBalanceInitial(Double userSendingBalanceInitial) {
        this.userSendingBalanceInitial = userSendingBalanceInitial;
    }

    public void setUserReceiveBalanceInitial(Double userReceiveBalanceInitial) {
        this.userReceiveBalanceInitial = userReceiveBalanceInitial;
    }
}
