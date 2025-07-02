package com.hpg.service.payments.models;

public class AccountUserModel {

    private Long userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String userAddress;
    private String userCity;
    private String userState;
    private String userCountry;
    private String userPostalCode;
    private String userPixKey;
    private String userPixKeyType;
    private Double uerValueBalance;
    private String userLastTransactionId;
    private String userLastTransactionDate;
    private String userLastTransactionAmount;

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

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
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

    public String getUserPostalCode() {
        return userPostalCode;
    }

    public void setUserPostalCode(String userPostalCode) {
        this.userPostalCode = userPostalCode;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
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

    public Double getUerValueBalance() {
        return uerValueBalance;
    }

    public void setUerValueBalance(Double uerValueBalance) {
        this.uerValueBalance = uerValueBalance;
    }

    public String getUserLastTransactionId() {
        return userLastTransactionId;
    }

    public void setUserLastTransactionId(String userLastTransactionId) {
        this.userLastTransactionId = userLastTransactionId;
    }

    public String getUserLastTransactionDate() {
        return userLastTransactionDate;
    }

    public void setUserLastTransactionDate(String userLastTransactionDate) {
        this.userLastTransactionDate = userLastTransactionDate;
    }

    public String getUserLastTransactionAmount() {
        return userLastTransactionAmount;
    }

    public void setUserLastTransactionAmount(String userLastTransactionAmount) {
        this.userLastTransactionAmount = userLastTransactionAmount;
    }
}
