package com.application.innova.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|security")
@Table(name = "INNOVA_INVESTOR_HOLDINGS")
@Entity(name = "innova$InvestorHoldings")
public class InvestorHoldings extends StandardEntity {
    private static final long serialVersionUID = 3366135134297078381L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INVESTOR_ID")
    protected Investor investor;

    @Column(name = "TRADE_STATUS")
    protected Integer tradeStatus;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SECURITY_ID")
    protected Security security;

    @Column(name = "TRADE_TYPE")
    protected Integer tradeType;

    @Column(name = "QUANTITY")
    protected Double quantity;

    @Column(name = "PRICE")
    protected Double price;

    @NotNull
    @Column(name = "TRADE_VALUE", nullable = false)
    protected Double tradeValue;

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getQuantity() {
        return quantity;
    }


    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.getId();
    }

    public TradeStatus getTradeStatus() {
        return tradeStatus == null ? null : TradeStatus.fromId(tradeStatus);
    }


    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.getId();
    }

    public TradeType getTradeType() {
        return tradeType == null ? null : TradeType.fromId(tradeType);
    }


    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }


    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public Security getSecurity() {
        return security;
    }

    public void setTradeValue(Double tradeValue) {
        this.tradeValue = tradeValue;
    }

    public Double getTradeValue() {
        return tradeValue;
    }


}