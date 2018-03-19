package com.application.innova.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s|narrative,cashAmount")
@Table(name = "INNOVA_INVESTOR_CASH_DEPOSIT")
@Entity(name = "innova$InvestorCashDeposit")
public class InvestorCashDeposit extends StandardEntity {
    private static final long serialVersionUID = -804256142945781127L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INVESTOR_ID")
    protected Investor investor;

    @NotNull
    @Column(name = "NARRATIVE", nullable = false)
    protected String narrative;

    @NotNull
    @Column(name = "CASH_AMOUNT", nullable = false)
    protected Double cashAmount;

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Double getCashAmount() {
        return cashAmount;
    }


}