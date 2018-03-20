package com.application.innova.web.investor;

import com.application.innova.entity.InvestorCashDeposit;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.application.innova.entity.Investor;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class InvestorEdit extends AbstractEditor<Investor> {

    @Inject
    private CollectionDatasource<InvestorCashDeposit, UUID> cashAccountTransactionsDs;
    @Inject
    private Datasource<Investor> investorDs;

    /**
     * Hook to be implemented in subclasses. Called by the framework when all validation is done and datasources are
     * going to be committed.
     *
     * @return true to continue, false to abort
     */
    @Override
    protected boolean preCommit() {

        double cashTotals=0;

        Collection<InvestorCashDeposit> investorCashDeposits = cashAccountTransactionsDs.getItems();


        for(InvestorCashDeposit investorCashDeposit : investorCashDeposits){
            cashTotals = cashTotals+investorCashDeposit.getCashAmount();
        }
        investorDs.getItem().setCashAccountBalance(cashTotals);
        return super.preCommit();
    }
}