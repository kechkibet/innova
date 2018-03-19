package com.application.innova.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.OneToMany;

@NamePattern("%s|name")
@Table(name = "INNOVA_INVESTOR")
@Entity(name = "innova$Investor")
public class Investor extends StandardEntity {
    private static final long serialVersionUID = 4634064818942520960L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "investor")
    protected List<InvestorCashDeposit> cashAccountTransactions;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "investor")
    protected List<InvestorHoldings> holdings;

    @Column(name = "CASH_ACCOUNT_BALANCE")
    protected Double cashAccountBalance;

    public void setCashAccountTransactions(List<InvestorCashDeposit> cashAccountTransactions) {
        this.cashAccountTransactions = cashAccountTransactions;
    }

    public List<InvestorCashDeposit> getCashAccountTransactions() {
        return cashAccountTransactions;
    }

    public void setHoldings(List<InvestorHoldings> holdings) {
        this.holdings = holdings;
    }

    public List<InvestorHoldings> getHoldings() {
        return holdings;
    }


    public void setCashAccountBalance(Double cashAccountBalance) {
        this.cashAccountBalance = cashAccountBalance;
    }

    public Double getCashAccountBalance() {
        return cashAccountBalance;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}