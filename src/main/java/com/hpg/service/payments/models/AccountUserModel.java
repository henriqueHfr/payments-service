package com.hpg.service.payments.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "account_user")
public class AccountUserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false, unique = true)
    private String userCpf;

    @Column(nullable = false, unique = true)
    private String userPhone;

    private String userAddress;
    private String userCity;
    private String userState;
    private String userCountry;
    private String userPostalCode;

    @Column(nullable = false, unique = true)
    private String userPixKey;

    private String userPixKeyType;

    @Column(nullable = false)
    private Double userValueBalance;

    private String userLastTransactionId;
    private Date userLastTransactionDate;
    private Double userLastTransactionAmount;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCpf() {
        return userCpf;
    }

    public void setUserCpf(String userCpf) {
        this.userCpf = userCpf;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserPostalCode() {
        return userPostalCode;
    }

    public void setUserPostalCode(String userPostalCode) {
        this.userPostalCode = userPostalCode;
    }

    public String getUserPixKey() {
        return userPixKey;
    }

    public void setUserPixKey(String userPixKey) {
        this.userPixKey = userPixKey;
    }

    public String getUserPixKeyType() {
        return userPixKeyType;
    }

    public void setUserPixKeyType(String userPixKeyType) {
        this.userPixKeyType = userPixKeyType;
    }

    public Double getUserValueBalance() {
        return userValueBalance;
    }

    public void setUserValueBalance(Double userValueBalance) {
        this.userValueBalance = userValueBalance;
    }

    public String getUserLastTransactionId() {
        return userLastTransactionId;
    }

    public void setUserLastTransactionId(String userLastTransactionId) {
        this.userLastTransactionId = userLastTransactionId;
    }

    public Date getUserLastTransactionDate() {
        return userLastTransactionDate;
    }

    public void setUserLastTransactionDate(Date userLastTransactionDate) {
        this.userLastTransactionDate = userLastTransactionDate;
    }

    public Double getUserLastTransactionAmount() {
        return userLastTransactionAmount;
    }

    public void setUserLastTransactionAmount(Double userLastTransactionAmount) {
        this.userLastTransactionAmount = userLastTransactionAmount;
    }
}