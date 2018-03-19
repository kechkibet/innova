package com.application.innova.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.FileDescriptor;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s - %s|dated,due")
@Table(name = "INNOVA_TREASURY_BONDS_TYPES")
@Entity(name = "innova$TreasuryBondsTypes")
public class TreasuryBondsTypes extends StandardEntity {
    private static final long serialVersionUID = 1977998485600331981L;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATED")
    protected Date dated;

    @Temporal(TemporalType.DATE)
    @Column(name = "DUE")
    protected Date due;

    @Temporal(TemporalType.DATE)
    @Column(name = "REDEEMABLE_DATE")
    protected Date redeemableDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCANNED_COPY_ID")
    protected FileDescriptor scannedCopy;

    @Column(name = "CURRENCY")
    protected String currency;

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }


    public void setDated(Date dated) {
        this.dated = dated;
    }

    public Date getDated() {
        return dated;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Date getDue() {
        return due;
    }

    public void setRedeemableDate(Date redeemableDate) {
        this.redeemableDate = redeemableDate;
    }

    public Date getRedeemableDate() {
        return redeemableDate;
    }

    public void setScannedCopy(FileDescriptor scannedCopy) {
        this.scannedCopy = scannedCopy;
    }

    public FileDescriptor getScannedCopy() {
        return scannedCopy;
    }


}