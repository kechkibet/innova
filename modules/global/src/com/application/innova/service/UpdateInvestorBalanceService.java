package com.application.innova.service;


import java.util.UUID;

public interface UpdateInvestorBalanceService {
    String NAME = "innova_UpdateInvestorBalanceService";

    void updateInvestorBalance(UUID investorId, double balance);
}