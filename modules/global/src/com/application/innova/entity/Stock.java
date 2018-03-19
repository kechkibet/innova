package com.application.innova.entity;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@DiscriminatorValue("S")
@Entity(name = "innova$Stock")
public class Stock extends Security {
    private static final long serialVersionUID = 6522134134351005876L;

    @Column(name = "QUANTITY")
    protected Double quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    protected ListedCompany company;

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }


    public void setCompany(ListedCompany company) {
        this.company = company;
    }

    public ListedCompany getCompany() {
        return company;
    }



}