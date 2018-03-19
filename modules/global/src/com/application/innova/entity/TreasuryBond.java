package com.application.innova.entity;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@DiscriminatorValue("T")
@Entity(name = "innova$TreasuryBond")
public class TreasuryBond extends Security {
    private static final long serialVersionUID = -8148440159613402863L;

    @Column(name = "FACE_VALUE")
    protected Double faceValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOND_TYPE_ID")
    protected TreasuryBondsTypes bondType;

    public Double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Double faceValue) {
        this.faceValue = faceValue;
    }


    public void setBondType(TreasuryBondsTypes bondType) {
        this.bondType = bondType;
    }

    public TreasuryBondsTypes getBondType() {
        return bondType;
    }



}