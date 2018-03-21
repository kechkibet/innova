package com.application.innova.service;

import com.application.innova.entity.TradeStatus;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service(GetStockBalanceService.NAME)
public class GetStockBalanceServiceBean implements GetStockBalanceService {

    @Inject
    private Persistence persistence;

    @Override
    public double getStockBalance(UUID investorID, UUID stockId) {
        double balance = 0;
        //this whole code for services needs a reworrk, try catch the transaction!
        Transaction transaction = persistence.createTransaction();

        Query query = persistence.getEntityManager().createQuery("select coalesce(sum(s.quantity),0) from innova$InvestorHoldings s where s.investor.id=:investorId and s.security.id=:stockId and s.tradeStatus=:tradeStatus");
        query.setParameter("investorId", investorID);
        query.setParameter("stockId", stockId);
        query.setParameter("tradeStatus", TradeStatus.Complete);

        balance = (double) query.getFirstResult();

        transaction.close();

        return balance;
        //return 0;
    }
}