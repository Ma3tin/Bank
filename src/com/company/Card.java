package com.company;

public class Card {
    private String fullName;
    private int pinCode;
    private String cardVerificationCode;
    private String cardNumber;

    public void setCardVerificationCode(String cardVerificationCode) {
        this.cardVerificationCode = cardVerificationCode;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getCardVerificationCode() {
        return cardVerificationCode;
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}