package com.application.innova.service;

import com.application.innova.entity.Investor;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service(UpdateInvestorBalanceService.NAME)
public class UpdateInvestorBalanceServiceBean implements UpdateInvestorBalanceService {

    @Inject
    private Persistence persistence;

    @Override
    public void updateInvestorBalance(UUID investorId, double balance) {
        Transaction transaction = persistence.createTransaction();

        EntityManager entityManager = persistence.getEntityManager();
        Investor investor = entityManager.find(Investor.class, investorId);

        investor.setCashAccountBalance(balance);
        entityManager.merge(investor);

        transaction.commit();
        transaction.close();
    }
}