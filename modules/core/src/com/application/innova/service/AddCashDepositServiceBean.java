package com.application.innova.service;

import com.application.innova.entity.Investor;
import com.application.innova.entity.InvestorCashDeposit;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.LoadContext;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service(AddCashDepositService.NAME)
public class AddCashDepositServiceBean implements AddCashDepositService {

    @Inject
    private Persistence persistence;

    @Override
    public void addCashDeposit(UUID investorId, String narrative, Double cashAmount) {
        Transaction transaction = persistence.createTransaction();

        EntityManager entityManager = persistence.getEntityManager();

        Investor investor = entityManager.find(Investor.class,investorId);

        InvestorCashDeposit investorCashDeposit = new InvestorCashDeposit();
        investorCashDeposit.setInvestor(investor);
        investorCashDeposit.setNarrative(narrative);
        investorCashDeposit.setCashAmount(cashAmount);
        entityManager.persist(investorCashDeposit);

        transaction.commit();
        transaction.close();
    }
}