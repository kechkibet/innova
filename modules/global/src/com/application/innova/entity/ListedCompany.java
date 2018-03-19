package com.application.innova.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s - |name,symbol")
@Table(name = "INNOVA_LISTED_COMPANY")
@Entity(name = "innova$ListedCompany")
public class ListedCompany extends StandardEntity {
    private static final long serialVersionUID = -2388587624572669065L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Column(name = "SYMBOL", nullable = false)
    protected String symbol;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }


}