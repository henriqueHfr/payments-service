package com.hpg.service.payments.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class PixPaymentModels {
    private String pixKey;
    private String pixKeyType;
    private String transactionId;
    private Double amount;
    private String comments;
    private Long userSendingId;

    public Long getUserSendingId() {
        return userSendingId;
    }

    public void setUserSendingId(Long userSendingId) {
        this.userSendingId = userSendingId;
    }

    public String getPixKey() {
        return pixKey;
    }

    public void setPixKey(String pixKey) {
        this.pixKey = pixKey;
    }

    public String getPixKeyType() {
        return pixKeyType;
    }

    public void setPixKeyType(String pixKeyType) {
        this.pixKeyType = pixKeyType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
