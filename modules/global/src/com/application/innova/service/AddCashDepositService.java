package com.application.innova.service;


import java.util.UUID;

public interface AddCashDepositService {
    String NAME = "innova_AddCashDepositService";

    void addCashDeposit(UUID investorId, String narrative, Double cashAmount);
}