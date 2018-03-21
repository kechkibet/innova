package com.application.innova.service;


import java.util.UUID;

public interface GetStockBalanceService {
    String NAME = "innova_GetStockBalanceService";

    double getStockBalance(UUID investorID, UUID stockId);
}